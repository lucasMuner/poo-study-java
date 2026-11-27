package br.com.lucasmuner.pooproject.models;

import br.com.lucasmuner.pooproject.interfaces.AudioInterface;
import br.com.lucasmuner.pooproject.interfaces.DescribableInterface;
import br.com.lucasmuner.pooproject.interfaces.UserInterface;

public class User implements UserInterface, DescribableInterface {
    private String name;
    private double totalMinutesPlayed;
    private int totalLikes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name is required!");
        }
        this.name = name;
    }

    @Override
    public void listen(AudioInterface audio, boolean liked) {
        this.addMinutesPlayed(audio);
        if (liked) {
            this.likeAudio(audio);
        }
    }

    private void likeAudio(AudioInterface audio) {
        audio.like();
        this.totalLikes++;
    }

    private void addMinutesPlayed(AudioInterface audio) {
        audio.play();
        this.totalMinutesPlayed += audio.getDuration();
    }

    @Override
    public String describe() {
        return """
                Your Data:
                     - Total Likes Given: %d
                     - Total Minutes Played: %.2f
            """.formatted(
                this.totalLikes,
                this.totalMinutesPlayed);
    }
}