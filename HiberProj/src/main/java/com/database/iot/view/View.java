package com.database.iot.view;

import com.database.iot.controller.impl.*;
import com.database.iot.model.entities.*;
import net.sf.saxon.trans.SymbolicName;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    private final ClientController clientController;
    private final ClientWithTrainerController clientWithTrainerController;
    private final ExerciseController exerciseController;
    private final FitnessMachineController fitnessMachineController;
    private final GymController gymController;
    private final TrainerController trainerController;
    private final TrainingTypeController trainingTypeController;

    private final Map<String, Printable> menu = new LinkedHashMap<>();

    public View(){
        clientController = new ClientController();
        clientWithTrainerController = new ClientWithTrainerController();
        exerciseController=new ExerciseController();
        fitnessMachineController=new FitnessMachineController();
        gymController=new GymController();
        trainerController=new TrainerController();
        trainingTypeController = new TrainingTypeController();

        menu.put("11", this::getAllClient);
        menu.put("12", this::getClientById);
        menu.put("13", this::createClient);
        menu.put("14", this::updateClient);
        menu.put("15", this::deleteClient);

        menu.put("21", this::getAllClientWithTrainer);
        menu.put("22", this::getClientWithTrainerById);
        menu.put("23", this::createClientWithTrainer);
        menu.put("24", this::updateClientWithTrainer);
        menu.put("25", this::deleteClientWithTrainer);

        menu.put("31", this::getAllExercise);
        menu.put("32", this::getExerciseById);
        menu.put("33", this::createExercise);
        menu.put("34", this::updateExercise);
        menu.put("35", this::deleteExercise);

        menu.put("41", this::getAllFitnessMachine);
        menu.put("42", this::getFitnessMachineById);
        menu.put("43", this::createFitnessMachine);
        menu.put("44", this::updateFitnessMachine);
        menu.put("45", this::deleteFitnessMachine);

        menu.put("51", this::getGym);
        menu.put("52", this::getGymById);
        menu.put("53", this::createGym);
        menu.put("54", this::updateGym);
        menu.put("55", this::deleteGym);

        menu.put("61", this::getTrainer);
        menu.put("62", this::getTrainerById);
        menu.put("63", this::createTrainer);
        menu.put("64", this::updateTrainer);
        menu.put("65", this::deleteTrainer);

        menu.put("71", this::getAllTrainingType);
        menu.put("72", this::getTrainingTypeById);
        menu.put("73", this::createTrainingType);
        menu.put("74", this::updateTrainingType);
        menu.put("75", this::deleteTrainingType);
    }



    public void displayMenu(){
        System.out.println("----------------------------------------------------------");

        System.out.println("  X - entity number:         |        Y - CRUD number:");
        System.out.println("  1 - Client                 |        1 - GET ALL");
        System.out.println("  2 - Client with trainer    |        2 - GET ONE");
        System.out.println("  3 - Exercise               |        3 - CREATE");
        System.out.println("  4 - Fitness machine        |        4 - UPDATE");
        System.out.println("  5 - Gym                    |        5 - DELETE");
        System.out.println("  6 - Trainer                |                     ");
        System.out.println("  7 - Training type          |                     ");

        System.out.println("----------------------------------------------------------");
    }

    private void getAllClient(){
        System.out.println("\n[Client / GET]");
        System.out.println(clientController.findAll() + "\n");
    }
    private void getClientById(){
        System.out.println("\n [Client / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(clientController.findOne(id) + "\n");
    }
    private Client getClientInputs(){
        System.out.println("Enter first name  : ");
        String first_name = scanner.next();
        System.out.println("Enter second name  : ");
        String second_name = scanner.next();
        System.out.println("Enter email  : ");
        String email = scanner.next();
        System.out.println("Enter phone number : ");
        String phone_number = scanner.next();
        System.out.println("Enter training type id : ");
        Integer training_type_id = scanner.nextInt();

        return new Client(0, first_name, second_name, email, phone_number, training_type_id);
    }
    private void createClient(){
        System.out.println("\n[Client / CREATE]");
        Client client = getClientInputs();
        clientController.create(client);
        System.out.println("Client successfully created\n");
    }
    private void updateClient(){
        System.out.println("\n[Client / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Client client = getClientInputs();
        client.setId(id);
        clientController.update(client.getId(), client);

        System.out.println("Client with ID = " + id + " successfully updated");
    }
    private void deleteClient(){
        System.out.println("[Client / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        clientController.delete(id);
        System.out.println("Client with ID = " + id + " successfully deleted");
    }

    private void getAllClientWithTrainer(){
        System.out.println("\n[Client with trainer / GET]");
        System.out.println(clientWithTrainerController.findAll() + "\n");
    }
    private void getClientWithTrainerById(){
        System.out.println("\n [Client with trainer / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(clientWithTrainerController.findOne(id) + "\n");
    }
    private ClientWithTrainer getClientWithTrainerInputs(){
        System.out.println("Enter name  : ");
        String name = scanner.next();
        System.out.println("Enter surname  : ");
        String surname = scanner.next();
        System.out.println("Enter phone number : ");
        String phone_number = scanner.next();

        return new ClientWithTrainer(0, name, surname, phone_number);
    }
    private void createClientWithTrainer(){
        System.out.println("\n[Client with trainer / CREATE]");
        ClientWithTrainer clientWithTrainer = getClientWithTrainerInputs();
        clientWithTrainerController.create(clientWithTrainer);
        System.out.println("Client with trainer successfully created\n");
    }
    private void updateClientWithTrainer(){
        System.out.println("\n[Client with trainer / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        ClientWithTrainer clientWithTrainer = getClientWithTrainerInputs();
        clientWithTrainer.setId(id);
        clientWithTrainerController.update(clientWithTrainer.getId(), clientWithTrainer);

        System.out.println("Client with ID = " + id + " successfully updated");
    }
    private void deleteClientWithTrainer(){
        System.out.println("[Client with trainer / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        clientWithTrainerController.delete(id);
        System.out.println("Client with trainer with ID = " + id + " successfully deleted");
    }

    private void getAllExercise(){
        System.out.println("\n[Exercise with trainer / GET]");
        System.out.println(exerciseController.findAll() + "\n");
    }
    private void getExerciseById(){
        System.out.println("\n [Exercise with trainer / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(exerciseController.findOne(id) + "\n");
    }
    private Exercise getExerciseInputs(){
        System.out.println("Enter burning calories  : ");
        Integer burning_calories = scanner.nextInt();
        System.out.println("Enter time of set   : ");
        Integer time_of_set = scanner.nextInt();
        System.out.println("Enter training type id : ");
        Integer training_type_id = scanner.nextInt();
        System.out.println("Enter fitness machine id : ");
        Integer fitness_machine_id = scanner.nextInt();
        return new Exercise(0, burning_calories, time_of_set, training_type_id, fitness_machine_id);
    }
    private void createExercise(){
        System.out.println("\n[Exercise / CREATE]");
        Exercise exercise = getExerciseInputs();
        exerciseController.create(exercise);
        System.out.println("Exercise successfully created\n");
    }
    private void updateExercise(){
        System.out.println("\n[Exercise / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Exercise exercise = getExerciseInputs();
        exercise.setId(id);
        exerciseController.update(exercise.getId(), exercise);

        System.out.println("Exercise with ID = " + id + " successfully updated");
    }
    private void deleteExercise(){
        System.out.println("[Exercise / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        exerciseController.delete(id);
        System.out.println("Exercise with ID = " + id + " successfully deleted");
    }

    private void getAllFitnessMachine(){
        System.out.println("\n[Fitness machine / GET]");
        System.out.println(fitnessMachineController.findAll() + "\n");
    }
    private void getFitnessMachineById(){
        System.out.println("\n [Fitness machine / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(fitnessMachineController.findOne(id) + "\n");
    }
    private FitnessMachine getFitnessMachineInputs(){
        System.out.println("Enter type machine  : ");
        String type_machine = scanner.next();

        return new FitnessMachine(0, type_machine);
    }
    private void createFitnessMachine(){
        System.out.println("\n[Fitness machine / CREATE]");
        FitnessMachine fitnessMachine = getFitnessMachineInputs();
        fitnessMachineController.create(fitnessMachine);
        System.out.println("Fitness machine successfully created\n");
    }
    private void updateFitnessMachine(){
        System.out.println("\n[Fitness machine / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        FitnessMachine fitnessMachine = getFitnessMachineInputs();
        fitnessMachine.setId(id);
        fitnessMachineController.update(fitnessMachine.getId(), fitnessMachine);

        System.out.println("Fitness machine with ID = " + id + " successfully updated");
    }
    private void deleteFitnessMachine(){
        System.out.println("[Fitness machine / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        fitnessMachineController.delete(id);
        System.out.println("Fitness machine with ID = " + id + " successfully deleted");
    }

    private void getGym(){
        System.out.println("\n[Gym / GET]");
        System.out.println(gymController.findAll() + "\n");
    }
    private void getGymById(){
        System.out.println("\n [Gym / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(gymController.findOne(id) + "\n");
    }
    private Gym getGymInputs(){
        System.out.println("Enter name  : ");
        String name = scanner.next();
        System.out.println("Enter sity  : ");
        String sity = scanner.next();
        System.out.println("Enter street : ");
        String street = scanner.next();

        return new Gym(0, name, sity, street);
    }
    private void createGym(){
        System.out.println("\n[Gym / CREATE]");
        Gym gym = getGymInputs();
        gymController.create(gym);
        System.out.println("Gym successfully created\n");
    }
    private void updateGym(){
        System.out.println("\n[gym / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Gym gym = getGymInputs();
        gym.setId(id);
        gymController.update(gym.getId(), gym);

        System.out.println("gym with ID = " + id + " successfully updated");
    }
    private void deleteGym(){
        System.out.println("[ gym / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        gymController.delete(id);
        System.out.println("gym with ID = " + id + " successfully deleted");
    }


    private void getTrainer(){
        System.out.println("\n[Trainer / GET]");
        System.out.println(trainerController.findAll() + "\n");
    }
    private void getTrainerById(){
        System.out.println("\n [Trainer / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(trainerController.findOne(id) + "\n");
    }
    private Trainer getTrainerInputs(){
        System.out.println("Enter name  : ");
        String name = scanner.next();
        System.out.println("Enter surname  : ");
        String surname = scanner.next();
        System.out.println("Enter phone number : ");
        String phone_number = scanner.next();
        System.out.println("Enter client with trainer id : ");
        Integer client_with_trainer_id = scanner.nextInt();

        return new Trainer(0, name, surname, phone_number, client_with_trainer_id);
    }
    private void createTrainer(){
        System.out.println("\n[Trainer / CREATE]");
        Trainer trainer = getTrainerInputs();
        trainerController.create(trainer);
        System.out.println("Trainer successfully created\n");
    }
    private void updateTrainer(){
        System.out.println("\n[trainer / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        Trainer trainer = getTrainerInputs();
        trainer.setId(id);
        trainerController.update(trainer.getId(), trainer);

        System.out.println("trainer with ID = " + id + " successfully updated");
    }
    private void deleteTrainer(){
        System.out.println("[ trainer / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        trainerController.delete(id);
        System.out.println("trainer with ID = " + id + " successfully deleted");
    }

    private void getAllTrainingType(){
        System.out.println("\n[Training type / GET]");
        System.out.println(trainingTypeController.findAll() + "\n");
    }
    private void getTrainingTypeById(){
        System.out.println("\n [Training type / GET] Enter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(trainingTypeController.findOne(id) + "\n");
    }
    private TrainingType getTrainingTypeInputs(){
        System.out.println("Enter type  : ");
        String type = scanner.next();
        System.out.println("Enter number of sets  : ");
        Integer number_of_sets = scanner.nextInt();
        System.out.println("Enter number of days  : ");
        Integer numbers_of_days = scanner.nextInt();
        return new TrainingType(0, type, number_of_sets, numbers_of_days);
    }
    private void createTrainingType(){
        System.out.println("\n[Training type / CREATE]");
        TrainingType trainingType = getTrainingTypeInputs();
        trainingTypeController.create(trainingType);
        System.out.println("Training type successfully created\n");
    }
    private void updateTrainingType(){
        System.out.println("\n[Training type / UPDATE] Enter ID: ");
        Integer id = scanner.nextInt();
        TrainingType trainingType = getTrainingTypeInputs();
        trainingType.setId(id);
        trainingTypeController.update(trainingType.getId(), trainingType);

        System.out.println("Client with ID = " + id + " successfully updated");
    }
    private void deleteTrainingType(){
        System.out.println("[Training type / DELETE] Enter ID: ");
        int id = scanner.nextInt();

        clientController.delete(id);
        System.out.println("Client with ID = " + id + " successfully deleted");
    }

    public final void show() {
        String input;
        displayMenu();
        System.out.println("\nChoose your table:\n");
        do {
            try {
                input = scanner.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (scanner.hasNext());
    }

}



