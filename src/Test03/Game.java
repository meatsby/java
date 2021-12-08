package Test03;

import static Test03.Constants.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private final Scanner sc;
	
	public Game(Scanner sc) {
		this.sc = sc;
	}

	public void play() {
		List<Stage> stages = init();

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

	private List<Stage> init() {
		String stageName = "";
		List<List<String>> stageMap = new ArrayList<>();
		List<Stage> stages = new ArrayList<>();
		for (String line : readFile()) {
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

	private List<String> readFile() {
		List<String> file = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(DIRECTORY))) {
			String line;
			while ((line = br.readLine()) != null) {
				file.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
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
				runStage(init(), i);
				break;
			}
			count++;
			boolean result = stage.move(cmd, player.location());
			if (result) {
				System.out.println(CLEAR_COUNT_MESSAGE + count);
				break;
			}
		}
	}
}
