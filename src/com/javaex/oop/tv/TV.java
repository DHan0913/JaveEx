package com.javaex.oop.tv;

class TV {
    //상수 
	//해당 클래스에선 설정하지 않았음
	//private static final ~~
	
	//필드
	private int channel;
    private int volume;
    private boolean power;

    // 생성자
    public TV(int channel, int volume, boolean power) { //A
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
    
    //채널 변경 메서드
    public void channel(int channel) {
        if (channel >= 1 && channel <= 255) {
            this.channel = channel;
        }
    }

    //채널 변경 메서드(오버로딩)
    public void channel(boolean up) {
        if (up) {	//채널 올림 
            if (channel < 255) { //최대 채널
                channel++;			// 채널 올림
            }
        } else if (channel > 1) { //최소 채널
               channel--;			// 채널 내림
            }
        }
    

    public void volume(int volume) { 
        if (volume >= 0 && volume <= 100) { //볼륨 제한
            this.volume = volume;			//볼륨 설정
        }
    }

    public void volume(boolean up) { 
        if (up) {
            if (volume < 100) { //최대 볼륨
                volume++;		//볼륨 올림
            }
        } else if (volume > 0) { //최소 볼륨
                volume--;		 //볼륨 내림
            }
        }
    

    public void status() { 
    	if (power == true) {
    		System.out.println("TV 채널: " + channel);
    	    System.out.println("TV 볼륨: " + volume);
    	    System.out.println("TV 전원: " + (power ? "ON" : "OFF"));
    	} else {
    		System.out.println("전원 off 상태표시 안함");
    	}
       
    }
    
    public void status(int tvnum) {
    	if (tvnum==1 && power == true) {
    		System.out.println("TV 채널: " + channel);
            System.out.println("TV 볼륨: " + volume);
            System.out.println("TV 전원: " + (power ? "ON" : "OFF"));
    	}
    	if (tvnum==2 && power == true) {
    		System.out.println("TV2 채널: " + channel);
            System.out.println("TV2 볼륨: " + volume);
            System.out.println("TV2 전원: " + (power ? "ON" : "OFF"));
    	} else {
    		System.out.println("전원 off 상태표시 안함");
    	}
    }
       
}
