public class Student implements Comparable{

    int score;

    public Student(int score) {
        // TODO Auto-generated constructor stub
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub

        if(o instanceof Student){
            Student s = (Student) o;
            if(this.getScore()> s.getScore()) return 1;
            else if(this.getScore()< s.getScore()) return -1;
            return 0;
        }
        throw new RuntimeException("类型不对，无法匹配");
    }

}

