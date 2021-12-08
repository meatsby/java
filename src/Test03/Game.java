package Test03;

import static Test03.Constants.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
	private final Scanner sc;
	private List<Stage> previousStage;
	private List<Stage> originalStage;
	private final List<String>[] saved = new List[5];
	private final int[] savedStage = new int[5];
	private final int[] savedCount = new int[5];
	private final List<String> saveFile = Arrays.asList("1S", "2S", "3S", "4S", "5S");
	private final List<String> loadFile = Arrays.asList("1L", "2L", "3L", "4L", "5L");

	public Game(Scanner sc) {
		this.sc = sc;
	}

	public void play() {
		List<Stage> stages = init(DIRECTORY);

		System.out.println(START_MESSAGE);
		System.out.println(START_EMOJI);

		for (int i = 0; i < stages.size(); i++) {
			stages.get(i).printStageName();
			runStage(stages, i, CLEAR_COUNT);
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
			writer.append("=====");
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

	private void runStage(List<Stage> stages, int i, int count) {
		Stage stage = stages.get(i);
		Player player = stage.player;
		while (true) {
			stage.printMap();
			System.out.print(SOKOBAN_PROMPT);
			String cmd = sc.nextLine();
			if (cmd.equals(RESET_CMD)) {
				runStage(init(DIRECTORY), i, count);
				break;
			}
			if (cmd.equals(PREV_CMD)) {
				runStage(previousStage, CURRENT_STAGE, count-1);
				break;
			}
			if (cmd.equals(ORIG_CMD)) {
				runStage(originalStage, CURRENT_STAGE, count+1);
				break;
			}
			if (saveFile.contains(cmd)) {
				System.out.println(cmd.charAt(0) + "번 세이브 슬로 상태");
				System.out.println(cmd.charAt(0) + "번 세이브에 진행상황을 저장합니다.");
				saved[cmd.charAt(0)-49] = saveGame(stages);
				savedStage[cmd.charAt(0)-49] = i;
				savedCount[cmd.charAt(0)-49] = count;
			}
			if (loadFile.contains(cmd)) {
				System.out.println(cmd.charAt(0) + "번 세이브에서 진행상황을 불러옵니다.");
				playSaved(init(writeSavedFile(saved[cmd.charAt(0)-49], cmd.charAt(0) + "S")), savedStage[cmd.charAt(0)-49], savedCount[cmd.charAt(0)-49]);
				System.exit(0);
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

	private List<String> saveGame(List<Stage> stages) {
		List<String> saved = new ArrayList<>();
		for (Stage stage : stages) {
			saved.add(stage.getStageName());
			for (List<String> row : stage.getStageMap()) {
				saved.add(getLine(row));
			}
			saved.add("=====");
		}
		return saved;
	}

	private String getLine(List<String> row) {
		StringBuilder line = new StringBuilder();
		for (String point : row) {
			line.append(point);
		}
		return line.toString();
	}

	private String writeSavedFile(List<String> saved, String name) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_DIRECTORY + name + FILE_TYPE))) {
			for (String line : saved) {
				writer.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SAVE_DIRECTORY + name + FILE_TYPE;
	}

	private void playSaved(List<Stage> stages, int stageLevel, int count) {
		while (stageLevel < stages.size()) {
			stages.get(stageLevel).printStageName();
			runStage(stages, stageLevel, count);
			stageLevel++;
		}

		System.out.println();
		System.out.println(CLEAR_MESSAGE);
		System.out.println(CONGRATS_MESSAGE);
	}
}
