package Test03;

import static Test03.Constants.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private final Scanner sc;
	private List<Stage> previousStage;
	private List<Stage> originalStage;
	
	public Game(Scanner sc) {
		this.sc = sc;
	}

	public void play() {
		List<Stage> stages = init(DIRECTORY);

		System.out.println(START_MESSAGE);
		System.out.println(START_EMOJI);

		for (int i = 0; i < stages.size(); i++) {
			stages.get(i).printStageName();
			runStage(stages, i);
		}

		System.out.println();
		System.out.println(CLEAR_MESSAGE);
		System.out.println(CONGRATS_MESSAGE);
	}

	private List<Stage> init(String dir) {
		String stageName = "";
		List<List<String>> stageMap = new ArrayList<>();
		List<Stage> stages = new ArrayList<>();
		for (String line : readFile(dir)) {
			if (line.contains(STAGE_INDICATOR)) {
				stageName = line;
				stageMap = new ArrayList<>();
				continue;
			}
			if (line.contains(END_INDICATOR)) {
				Stage map = new Stage(stageName, stageMap);
				stages.add(map);
				continue;
			}
			stageMap.add(createRow(line));
		}
		return stages;
	}

	private List<String> readFile(String dir) {
		List<String> file = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(dir))) {
			String line;
			while ((line = br.readLine()) != null) {
				file.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	private String writeFile(Stage stage, String name) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_DIRECTORY + name + FILE_TYPE))) {
			writer.append(stage.getStageName()).append("\n");
			for (String line : stage.saveMap()) {
				writer.append(line).append("\n");
			}
			writer.append("=");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SAVE_DIRECTORY + name + FILE_TYPE;
	}

	private List<String> createRow(String line) {
		List<String> row = new ArrayList<>();
		for (int i = 0; i < line.length(); i++) {
			row.add(Character.toString(line.charAt(i)));
		}
		return row;
	}

	private void runStage(List<Stage> stages, int i) {
		Stage stage = stages.get(i);
		Player player = stage.player;
		int count = CLEAR_COUNT;
		while (true) {
			stage.printMap();
			System.out.print(SOKOBAN_PROMPT);
			String cmd = sc.nextLine();
			if (cmd.equals(RESET_CMD)) {
				runStage(init(DIRECTORY), i);
				break;
			}
			if (cmd.equals(PREV_CMD)) {
				runStage(previousStage, CURRENT_STAGE);
				break;
			}
			if (cmd.equals(ORIG_CMD)) {
				runStage(originalStage, CURRENT_STAGE);
				break;
			}
			previousStage = init(writeFile(stage, PREV));
			boolean result = stage.move(cmd, player.location());
			count++;
			originalStage = init(writeFile(stage, ORIG));
			if (result) {
				System.out.println(CLEAR_COUNT_MESSAGE + count);
				break;
			}
		}
	}
}
