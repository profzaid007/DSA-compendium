import java.util.*;

public class Main {
    public static String solution(String[] logs) {
        Map<String, Set<String>> branches = new HashMap<>();
        String currentBranch = null;

        for (String log : logs) {
            String[] parts = log.split(" ");
            String command = parts[0];
            String name = parts[1];

            if (command.equals("switch")) {
                currentBranch = name;
                branches.putIfAbsent(currentBranch, new HashSet<>());
            } else if (command.equals("push")) {
                if (currentBranch != null) {
                    branches.get(currentBranch).add(name);
                }
            }
        }


        int maxFiles = -1;
        String resultBranch = null;

        for (Map.Entry<String, Set<String>> entry : branches.entrySet()) {
            String branch = entry.getKey();
            int numFiles = entry.getValue().size();
            if (numFiles > maxFiles) {
                maxFiles = numFiles;
                resultBranch = branch;
            }
        }

        return resultBranch;
    }

    public static void main(String[] args) {
        String[] logs = {
            "switch branch1",
            "push file1",
            "push file2",
            "push file1",
            "switch branch2",
            "switch issue2",
            "push file1",
            "push file2",
            "push file3"
        };
        System.out.println(solution(logs));  
    }
}
