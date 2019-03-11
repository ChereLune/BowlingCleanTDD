
public class Scorer {
	public void addThrow(int pins) {
		itsThrows[itsCurrentThrow++] = pins;
	}
	//프레임별 스코어 계산
	public int scoreForFrame(int theFrame) {
		ball = 0; //투구
		int score = 0; //점수
		for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
			if (strike()) { // 스트라이크
				score += 10 + nextTwoBallsForStrike();
				ball++;
			} else if (spare()) {
				score += 10 + nextBallForSpare();
				ball += 2;
			} else {
				score += twoBallsInFrame();
				ball += 2;
			}
		}
		return score;
	}
	//스트라이크 판별여부
	private boolean strike() {
		return itsThrows[ball] == 10;
	}
	//스페어 판별여부
	private boolean spare() {
		return (itsThrows[ball] + itsThrows[ball + 1]) == 10;
	}
	//연속 스트라이크
	private int nextTwoBallsForStrike() {
		return itsThrows[ball + 1] + itsThrows[ball + 2];
	}
	//연속 스페어
	private int nextBallForSpare() {
		return itsThrows[ball + 2];
	}
	//스트라이크나 스페어 아닐 때
	private int twoBallsInFrame() {
		return itsThrows[ball] + itsThrows[ball + 1];
	}

	private int ball;
	private int[] itsThrows = new int[21];
	private int itsCurrentThrow = 0;
}
