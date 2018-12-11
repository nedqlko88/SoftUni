package com.ned.gamestore;

import com.ned.gamestore.controllers.GameController;
import com.ned.gamestore.controllers.OrderController;
import com.ned.gamestore.controllers.UserController;
import com.ned.gamestore.repositories.GameRepository;
import com.ned.gamestore.repositories.OrderRepository;
import com.ned.gamestore.repositories.UserRepository;
import com.ned.gamestore.services.impl.GameServiceImpl;
import com.ned.gamestore.services.impl.OrderServiceImpl;
import com.ned.gamestore.services.impl.UserServiceImpl;
import com.ned.gamestore.services.interfaces.GameService;
import com.ned.gamestore.services.interfaces.OrderService;
import com.ned.gamestore.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner {
    private final GameRepository gameRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private BufferedReader br;
    private HashMap<String, Object> cache;
    private HashMap<String, Class<?>> mappings;

    @Autowired
    public ConsoleRunner(UserRepository userRepository, GameRepository gameRepository, OrderRepository orderRepository) throws IOException {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.orderRepository = orderRepository;
        this.createMappings();
        this.createCacheRepositories();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            String[] input = br.readLine().split("\\|");
            String methodName = input[0].split("(?=\\p{Upper})")[0];
            String controllerName = input[0].split("(?=\\p{Upper})")[1];
            String pathName = "com.ned.gamestore.controllers." + controllerName + "Controller";
            Object controller = this.resolveParameters(pathName);
            Method[] methods = controller.getClass().getDeclaredMethods();
            Method mtd = Arrays.stream(methods).
                    filter(method -> method.getName().equals(methodName.toLowerCase())).
                    findFirst().get();
            Type[] params = mtd.getParameterTypes();
            Object[] methodArguments = new Object[mtd.getParameterCount()];

            for (int i = 0; i < params.length; i++) {
                if (params[i] == String.class) {
                    methodArguments[i] = input[i + 1];
                 } else if (params[i] == BigDecimal.class) {
                    methodArguments[i] = new BigDecimal(input[i + 1]);
                }
            }

            System.out.println(mtd.invoke(controller, methodArguments));


        }
    }

    private Object resolveParameters(String pathName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (this.cache.containsKey(pathName)) {
            return this.cache.get(pathName);
        }
        Class<?> clazz = mappings.get(pathName);
        Constructor constructor = clazz.getDeclaredConstructors()[0];
        Parameter[] params = constructor.getParameters();
        Object[] arguments = new Object[constructor.getParameterCount()];
        int i = 0;
        for (Parameter param : params) {
            arguments[i] = resolveParameters(param.getParameterizedType().getTypeName());
            i++;
        }
        Object instance = constructor.newInstance(arguments);
        this.cache.put(instance.getClass().getName(), instance);
        return instance;

    }

    private void createMappings() {
        this.mappings = new HashMap<>();
        this.mappings.put(OrderService.class.getName(), OrderServiceImpl.class);
        this.mappings.put(UserService.class.getName(), UserServiceImpl.class);
        this.mappings.put(GameService.class.getName(), GameServiceImpl.class);
        this.mappings.put(OrderController.class.getName(), OrderController.class);
        this.mappings.put(UserController.class.getName(), UserController.class);
        this.mappings.put(GameController.class.getName(), GameController.class);
        this.mappings.put(AuthenticationContext.class.getName(), AuthenticationContext.class);
    }

    private void createCacheRepositories() {
        this.cache = new HashMap<>();
        cache.put(UserRepository.class.getName(), this.userRepository);
        cache.put(GameRepository.class.getName(), this.gameRepository);
        cache.put(OrderRepository.class.getName(), this.orderRepository);
    }
}

