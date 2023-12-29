package lab4.act1;

public class Time implements Comparable<Time>, Cloneable {
	
	private long time; // in seconds

	public Time() {
		time = System.currentTimeMillis() / 1000;
	}

	public Time(int hour, int minute, int second) {
		time = hour * 3600 + minute * 60 + second;
	}

	public Time(long elapsedTime) {
		time = elapsedTime;
	}

	public int getHour() {
		return (int) (time / 3600 % 24);
	}

	public int getMinute() {
		return (int) (time / 60 % 60);
	}

	public int getSecond() {
		return (int) (time % 60);
	}

	public long getSeconds() {
		return time;
	}

	@Override
	public String toString() {
		int h = getHour(), m = getMinute(), s = getSecond();
		return String.format("%d %s %d %s %d %s", h, (h == 1) ? "hour" : "hours",
				m, (m == 1) ? "minute" : "minutes",
				s, (s == 1) ? "second" : "seconds");
	}

	@Override
	public int compareTo(Time o) {
		return (int) (time - o.time);
	}

	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
