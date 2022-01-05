package JavaStandard.ch06;

class Tv {
    String color;
    boolean power;
    int channel;

    void power() {
        power = !power;
    }
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }
}

class TvTest {
    public static void main(String[] args) {
        Tv t;
        t = new Tv();
        t.channel = 7;
        t.channelDown();
        System.out.println("현재 채널은 " + t.channel + " 입니다.");
    }
}

class TvTest2 {
    public static void main(String[] args) {
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.println("t1의 channel 값은 " + t1.channel + "입니다.");
        System.out.println("t2의 channel 값은 " + t2.channel + "입니다.");

        t1.channel = 7;
        System.out.println("t1의 channel 값을 7로 변경하였습니다.");

        System.out.println("t1의 channel 값은 " + t1.channel + "입니다.");
        System.out.println("t2의 channel 값은 " + t2.channel + "입니다.");
    }
}

class TvTest4 {
    public static void main(String args[]) {
        Tv[] tvArr = new Tv[3]; // 길이가 3인 Tv 객체 배열

        // Tv 객체를 생성해서 Tv 객체 배열의 각 요소에저장
        for(int i=0; i < tvArr.length; i++) {
            tvArr[i] = new Tv();
            tvArr[i].channel = i+10; // tvArr[i]의 channel 에 i+10을 저장
        }

        for (int i=0; i < tvArr.length; i++) {
            tvArr[i].channelUp (); // tvArr [i]의 메서드를 호출. 채널이 1증가
            System.out.printf("tvArr[%d].channel=%d%n", i, tvArr[i].channel);
        }
    } // main 의 끝
}
