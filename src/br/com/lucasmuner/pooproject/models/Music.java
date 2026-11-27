package br.com.lucasmuner.pooproject.models;

public class Music extends Audio {
    private final String genre;
    private final String artist;

    public Music(int code, String title, double duration, double rating, String artist, String genre) {
        super(code, title, duration, rating);
        this.genre = genre;
        this.artist = artist;
    }

    @Override
    public String describe() {
        return """
                (%d). Music:
                     - Title: %s
                     - Genre: %s
                     - Artist: %s
                     - Duration: %.2f
                     - Rating: %.2f
                     - Total Plays: %d
                     - Total Likes: %d
            """.formatted(
                this.getCode(),
                this.getTitle(),
                this.genre,
                this.artist,
                this.getDuration(),
                this.getRating(),
                this.getTotalPlays(),
                this.getLikes());
    }
}