
public class Game {
	public int score() {
		return scoreForFrame(itsCurrentFrame);
	}
	//투구하여 핀 입력
	public void add(int pins) {
		itsScorer.addThrow(pins);
		adjustCurrentFrame(pins);
	}
	//
	private void adjustCurrentFrame(int pins) {
		if (lastBallInFrame(pins))
			advanceFrame();
		else
			firstThrowInFrame = false;
	}
	//스트라이크거나 두번째 볼이었으면 프레임이 끝났다고 판별
	private boolean lastBallInFrame(int pins) {
		return strike(pins) || !firstThrowInFrame;
	}
	//스트라이크 판별여부
	private boolean strike(int pins) {
		return (firstThrowInFrame && pins == 10);
	}
	//
	private void advanceFrame() {
		itsCurrentFrame = Math.min(10, itsCurrentFrame + 1);
	}
	//프레임별 스코어 계산
	public int scoreForFrame(int theFrame) {
		return itsScorer.scoreForFrame(theFrame);
	}

	private int itsCurrentFrame = 1;
	private boolean firstThrowInFrame = true;
	private Scorer itsScorer = new Scorer();
}
