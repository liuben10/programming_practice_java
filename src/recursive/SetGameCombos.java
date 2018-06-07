package recursive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class SetGameCombos {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String...args) {
        solve(2, 3);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    private static class Solution {
        String solution;
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        public Solution copy() {
            return new Solution(new String(this.getSolution()), new LinkedHashMap<>(this.getCounts()));
        }
    }

    public static void solve(int N, int M) {
        LinkedHashMap<String, Integer> initial = new LinkedHashMap<>();
        for(int i = 0; i < N; i++) {
            initial.put("" + ALPHABET.charAt(i), 0);
        }
        solveHelper(N,  M, Solution.builder().solution("").counts(initial).build());
    }

    private static void solveHelper(int n, int m, Solution solution) {
        if (solution.getCounts().size() >= 1 && last(solution.getCounts().values().iterator()) >= m) {
            System.out.println(solution.solution);
        } else {
            for(int i = 0; i < n; i++) {
                Solution nextIteration = solution.copy();
                int oldVal = nextIteration.getCounts().get(String.valueOf(ALPHABET.charAt(i)));
                nextIteration.getCounts().remove(String.valueOf(ALPHABET.charAt(i)));
                nextIteration.getCounts().put(String.valueOf(ALPHABET.charAt(i)), oldVal + 1);
                nextIteration.setSolution(nextIteration.getSolution() + ALPHABET.charAt(i));
                solveHelper(n, m, nextIteration);
            }
        }
    }

    private static Integer last(Iterator<Integer> iterator) {
        int last = 0;
        while(iterator.hasNext()) {
            last = iterator.next();
        }
        return last;
    }
}

