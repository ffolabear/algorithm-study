package programmers.level02.cuttingArray;

public class cuttingArray_jola7373 {
    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int)(right - left+1)];

        int idx=0;
        for(long i = left; i <= right; i++){
            //행과 열의 값중 더 큰값이 그 숫자 이기때문에
            arr[idx++] = (int)Math.max(i/n + 1, i%n + 1);
            //+1을 해주는 이유(행과 열은 0에서 시작하니깐)
        }

        return arr;
    }
}
