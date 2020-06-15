//$Id$
package arraysProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class smallestNumber {

	public static void main(String[] args) {
		smallestNumber number = new smallestNumber();
		System.out.println(number.solution(new int[] { 2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18 }));
	}

	public String solution(int[] T) {

		int splitSize = T.length / 4;
		int start = 0;
		int[] newArray = new int[splitSize];
		List<Integer> result = new ArrayList<>();

		for (int number : T) {
			if (start == splitSize - 1) {
				newArray[start] = number;
				Arrays.sort(newArray);
				int amplitude = newArray[start] - newArray[0];
				result.add(amplitude);
				newArray = new int[splitSize];
				start = 0;
			} else {
				newArray[start] = number;
				start++;
			}
		}

		Integer highestAmplitude = Collections.max(result);
		int indexOfSeason = result.indexOf(highestAmplitude);

		switch (indexOfSeason) {

		case 0:
			return "WINTER";
		case 1:
			return "SPRING";
		case 2:
			return "SUMMER";
		case 3:
			return "AUTUMN";

		default:
			return null;
		}
	}
}
