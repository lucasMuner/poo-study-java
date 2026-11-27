package br.com.lucasmuner.pooproject.models;

import br.com.lucasmuner.pooproject.interfaces.AudioInterface;
import br.com.lucasmuner.pooproject.interfaces.DescribableInterface;

public abstract class Audio implements AudioInterface, DescribableInterface {
    private final int code;
    private final String title;
    private final double duration;
    private final double rating;
    private int likes;
    private int totalPlays;

    protected Audio(int code, String title, double duration, double rating) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("The title is required!");
        }

        if (duration <= 0) {
            throw new IllegalArgumentException("The duration must be greater than zero, but was " + duration);
        }

        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("The rating must be between 0 and 10, but was " + rating);
        }

        this.code = code;
        this.title = title;
        this.duration = duration;
        this.rating = rating;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public double getDuration() {
        return duration;
    }

    public double getRating() {
        return rating;
    }

    public int getLikes() {
        return likes;
    }

    public int getTotalPlays() {
        return totalPlays;
    }

    @Override
    public void like() {
        this.likes++;
    }

    @Override
    public void play() {
        this.totalPlays++;
    }
}