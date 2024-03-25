package com.javaex.oop.tv;

class TV {
    private int channel;
    private int volume;
    private boolean power;

    // 생성자

    public TV(int channel, int volume, boolean power) {
        this.channel = channel;
        this.volume = volume;
        this.power = power;
    }

    // Getter 메서드
    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPower() {
        return power;
    }

    // TV 제어 메서드
    public void power(boolean on) {
        this.power = on;
    }

    public void channel(int channel) {
        if (channel >= 1 && channel <= 255) {
            this.channel = channel;
        }
    }

    public void channel(boolean up) {
        if (up) {
            if (channel < 255) {
                channel++;
            }
        } else {
            if (channel > 1) {
                channel--;
            }
        }
    }

    public void volume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
        }
    }

    public void volume(boolean up) {
        if (up) {
            if (volume < 100) {
                volume++;
            }
        } else {
            if (volume > 0) {
                volume--;
            }
        }
    }

    public void status() {
        System.out.println("TV 채널: " + channel);
        System.out.println("TV 볼륨: " + volume);
        System.out.println("TV 전원: " + (power ? "ON" : "OFF"));
    }
}
