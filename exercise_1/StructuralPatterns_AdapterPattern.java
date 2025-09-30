package exercise_1;
interface MediaPlayer {
 void play(String audioType, String fileName);
}
class AdvancedMediaPlayer {
	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file: " + fileName);
 }
}
class MediaAdapter implements MediaPlayer {
	AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("mp4")) {
			advancedPlayer.playMp4(fileName);
		} else {
			System.out.println("Format not supported.");
		}
	}
}
class AudioPlayer implements MediaPlayer {
	private MediaAdapter adapter;

 public void play(String audioType, String fileName) {
     if (audioType.equalsIgnoreCase("mp3")) {
         System.out.println("Playing mp3 file: " + fileName);
     } else {
         adapter = new MediaAdapter();
         adapter.play(audioType, fileName);
     }
 }
}

public class StructuralPatterns_AdapterPattern {
 public static void main(String[] args) {
     AudioPlayer player = new AudioPlayer();
     player.play("mp3", "song.mp3");
     player.play("mp4", "movie.mp4");
 }
}

