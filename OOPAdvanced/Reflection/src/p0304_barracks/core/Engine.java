package p0304_barracks.core;

import p0304_barracks.annotations.Inject;
import p0304_barracks.contracts.*;
import p0304_barracks.contracts.Runnable;
import p0304_barracks.data.UnitRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
    private static final String COMMAND_PATH = "p0304_barracks.core.commands.";
    private static final String COMMAND = "Command";

    private Repository repository;
    private UnitFactory unitFactory;
    private String[] data;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpredCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private String interpredCommand(String[] data, String commandName) {
        this.data = data;
        try {
            commandName = commandName.toUpperCase();
            String commandClassName = commandName.charAt(0) + commandName.substring(1).toLowerCase();

            Class<?> commandClass = Class.forName(COMMAND_PATH + commandClassName + COMMAND);

            Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor();
            Executable command = (Executable) declaredConstructor.newInstance();

            this.injectDependencies(command);

            return command.execute();

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException("Invalid command!");
        }
    }

    private <T> void injectDependencies(T command) throws IllegalAccessException {
        Field[] commandFields = command.getClass().getDeclaredFields();
        Field[] engineFields = this.getClass().getDeclaredFields();

        for (Field commandField : commandFields) {
            commandField.setAccessible(true);
            if (commandField.isAnnotationPresent(Inject.class)) {
                for (Field engineField : engineFields) {
                    engineField.setAccessible(true);
                    if (commandField.getType().getSimpleName().equals(engineField.getType().getSimpleName()) && commandField.getType().equals(engineField.getType())) {
                        commandField.set(command, engineField.get(this));

                    }
                }
            }
        }


    }
}
