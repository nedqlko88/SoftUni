package p08_military_elit;

import p08_military_elit.contracts.Mission;
import p08_military_elit.contracts.Private;
import p08_military_elit.contracts.Repair;
import p08_military_elit.contracts.Soldier;
import p08_military_elit.impl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Soldier> soldiers = new LinkedHashMap<>();
        Map<String, Private> privates = new HashMap<>();

        String line;

        while (!"End".equals(line = reader.readLine())) {

            String[] tokens = line.split("\\s+");
            String soldierType = tokens[0];
            String id = tokens[1];
            String firstName = tokens[2];
            String lastName = tokens[3];
            double salary;

            Soldier soldier = null;

            switch (soldierType) {
                case "Private":
                    salary = Double.parseDouble(tokens[4]);
                    Private privateSoldier = new PrivateBase(id, firstName, lastName, salary);
                    soldiers.putIfAbsent(id, privateSoldier);
                    privates.putIfAbsent(id, privateSoldier);
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    List<String> privatesIds = Arrays.stream(tokens).skip(5).collect(Collectors.toList());
                    Set<Private> privatesSet = getPrivates(privatesIds, privates);
                    soldier = new LeutenantGeneralBase(id, firstName, lastName, salary, privatesSet);
                    break;
                case "Engineer":
                    try {
                        salary = Double.parseDouble(tokens[4]);
                        String corps = tokens[5];
                        String[] repairsTokens = Arrays.stream(tokens).skip(6)
                                .toArray(String[]::new);
                        Set<Repair> repairs = createRepairs(repairsTokens);
                        soldier = new EngineerBase(id, firstName, lastName, salary, corps, repairs);
                    } catch (IllegalArgumentException ignored) {
                        ;
                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(tokens[4]);
                    String corps = tokens[5];
                    String[] missionsTokens = Arrays.stream(tokens).skip(6)
                            .toArray(String[]::new);

                    Set<Mission> missions = createMissions(missionsTokens);
                    soldier = new CommandoBase(id, firstName, lastName, salary, corps, missions);

                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    soldier = new SpyBase(id, firstName, lastName, codeNumber);
                    break;
            }
            if (soldier != null) {
                soldiers.putIfAbsent(id, soldier);
            }

        }
        soldiers.values().forEach(s -> System.out.println(s.toString()));

    }

    private static Set<Repair> createRepairs(String[] repairsTokens) {

        Set<Repair> repairs = new LinkedHashSet<>();
        for (int i = 0; i < repairsTokens.length; i += 2) {
            String partName = repairsTokens[i];
            int hoursWork = Integer.parseInt(repairsTokens[i + 1]);

            Repair repair = new RepairImpl(partName, hoursWork);
            repairs.add(repair);
        }
        return repairs;
    }

    private static Set<Mission> createMissions(String[] missionTokens) {

        Set<Mission> missions = new LinkedHashSet<>();

        Mission mission;
        for (int i = 0; i < missionTokens.length; i += 2) {
            String codeName = missionTokens[i];
            String state = missionTokens[i + 1];
            try {

                mission = new MissionImpl(codeName, state);
                missions.add(mission);
            } catch (IllegalArgumentException ignored) {
                ;
            }


        }
        return missions;
    }


    private static Set<Private> getPrivates(List<String> privatesIds, Map<String, Private> privates) {
        return privates
                .values()
                .stream()
                .filter(p -> privatesIds.contains(p.getId()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
