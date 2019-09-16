import java.util.ArrayList;

/* [Program.java] */
public class Program {
	public static void main(String args[]) {
	
	Playlist studyPlaylist = new Playlist("Study");		
    Playlist rockPlaylist = new Playlist("Rock");
    
	Song rockSong1 = new Song("Nothing else matters");
    Song rockSong2 = new Song("Sultans of swing");
    
	rockPlaylist.add(rockSong1);
    rockPlaylist.add(rockSong2);
    
    Song studySong1 = new Song("Design Patterns");
    Song studySong2 = new Song("Software Architecture");

    studyPlaylist.setPlaybackSpeed(0.25f);
    studyPlaylist.add(studySong1);
    studyPlaylist.add(studySong2);
	studyPlaylist.add(rockPlaylist);
	studyPlaylist.play();
}

public interface IComponent 
{
    public void play();
    public void setPlaybackSpeed(float speed);
    public String getName();
}

// Component class
public class Playlist implements IComponent 
{
	public String playlistName;
	public ArrayList<IComponent> playlist = new ArrayList();

    public Playlist(String playlistName) 
    {
		this.playlistName = playlistName;
    }
    
    public void play()
    {
        playlist.get(0).play();
    }

    public void setPlaybackSpeed(float speed)
    {
        for (IComponent song : playlist) {
            song.setPlaybackSpeed(speed);
        }
    }

    public String getName()
    {
        return playlistName;
    }

    public void add(IComponent component)
    {
        playlist.add(component);
    }

    public void remove(IComponent component)
    {
        playlist.remove(component);
    }
}

// Leaf class
public class Song implements IComponent 
{
	public String songName;
	public float speed = 1;

    public Song(String songName) 
    {
		this.songName = songName;
    }
    
    public void play()
    {
        System.out.println("Playing music ...");
    }

    public void setPlaybackSpeed(float speed)
    {
        this.speed = speed;
    }

    public String getSongName()
    {
        return songName;
    }
}