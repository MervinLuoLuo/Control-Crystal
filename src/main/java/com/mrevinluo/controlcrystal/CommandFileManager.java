package com.mrevinluo.controlcrystal;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CommandFileManager {
    private static final String FILE_NAME = "Control_Commands.txt";
    private static final List<String> commands = new ArrayList<>();

    public static void init(Logger logger) {
        Path configDir = FabricLoader.getInstance().getConfigDir();
        Path file = configDir.resolve(FILE_NAME);

        try {
            if (!Files.exists(file)) {
                Files.createDirectories(file.getParent());
                String sample = "# Control_Commands.txt\n" +
                        "# 使用 '#' 注释行将会被忽略。\n" +
                        "# 示例命令: \n" +
                        "随机骚扰一名玩家\n";
                Files.write(file, sample.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW);
                logger.info("Created command file: {}", file.toAbsolutePath());
            }

            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            commands.clear();
            for (String line : lines) {
                String t = line.trim();
                if (t.isEmpty() || t.startsWith("#")) continue;
                commands.add(t);
            }

            logger.info("Loaded {} command(s) from {}", commands.size(), file.getFileName());
        } catch (IOException e) {
            logger.error("Failed to create or read {}", file, e);
        }
    }

    public static List<String> getCommands() {
        return List.copyOf(commands);
    }

    public static void reload(Logger logger) {
        init(logger);
    }

    /**
     * 返回随机一条命令,若没有命令则返回 null
     */
    public static String getRandomCommand() {
        if (commands.isEmpty()) return null;
        int idx = ThreadLocalRandom.current().nextInt(commands.size());
        return commands.get(idx);
    }


//      返回最多 count 条不重复的随机命令,若实际命令数少于 count 则返回全部

    public static List<String> getRandomCommands(int count) {
        if (commands.isEmpty() || count <= 0) return List.of();
        List<String> copy = new ArrayList<>(commands);
        Collections.shuffle(copy, ThreadLocalRandom.current());
        return List.copyOf(copy.subList(0, Math.min(count, copy.size())));
    }
}
