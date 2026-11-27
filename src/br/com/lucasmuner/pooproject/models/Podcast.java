package br.com.lucasmuner.pooproject.models;

public class Podcast extends Audio {
    private final String host;
    private final String guest;

    public Podcast(int code, String title, double duration, double rating, String host, String guest) {
        super(code, title, duration, rating);
        this.host = host;
        this.guest = guest;
    }

    @Override
    public String describe() {
        return """
                (%d). Podcast:
                     - Title: %s
                     - Host: %s
                     - Guest: %s
                     - Duration: %.2f
                     - Rating: %.2f
                     - Total Plays: %d
                     - Total Likes: %d
            """.formatted(
                this.getCode(),
                this.getTitle(),
                this.host,
                this.guest,
                this.getDuration(),
                this.getRating(),
                this.getTotalPlays(),
                this.getLikes());
    }
}