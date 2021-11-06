package Test.NHN;

import programmers.level02.findPrimeNum.FindPrimeNum_carnival77;

import java.util.*;

public class first {
    private static class Operation{
        OperationType type;
        Integer value;

        public Operation(OperationType type,Integer value){
            this.type = type;
            this.value=value;
        }
    }

    private static enum OperationType{
        branch,
        merge;
    }

    private static void solution(int numOfOperation, Operation[] operations){

        ArrayList<Integer> pos_nums = new ArrayList<>();

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=1; i<numOfOperation;i++){
            pos_nums.add(i+1);
        }

        for(int i=0;i<numOfOperation;i++){
            if(operations[i].type.toString() == "branch"){
                answer.add(Collections.min(pos_nums));
                pos_nums.remove(Collections.min(pos_nums));
            }
            else{
                int value = operations[i].value;
                answer.remove(Integer.valueOf(value));
                pos_nums.add(Integer.valueOf(value));
            }
        }
    }
    public static void main(String[] args) {
        int numOfOperations=6;
//        Operation[] operations = new Operation[] {new Operation(OperationType.branch)};
        FindPrimeNum_carnival77 sol = new FindPrimeNum_carnival77();
//        System.out.println(sol.solution(numbers));
    }
}
