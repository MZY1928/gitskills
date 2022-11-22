import java.util.ArrayList;

interface ISignUp{
    public boolean addStudent (int stuType);
    // 解析命令行输入的参数（格式），如文档描述

}
interface IParams {
    // 获取大班名额
    public int getBig();
    // 获取中班名额
    public int getMedium();
    // 获取小班名额
    public int getSmall();
    // 获取入学序列，例如 [1 2 2 3] 表示依次报名入学一名大班、中班、中班、小班学生
    public ArrayList<Integer> getPlanSignUp ();
}

public class SchoolSystem implements ISignUp, IParams {
    SchoolSystem(int big, int medium, int small){
        this.big=big;
        this.medium=medium;
        this.small=small;
    }
    int big;
    int medium;
    int small;
    int stuType;



    public boolean addStudent(int stuType) {
        if (stuType == 1 && big > 0) {
            big--;
            return true;
        } else if (stuType == 2 && medium > 0) {
            medium--;
            return true;
        } else if (stuType == 3 && small > 0) {
            small--;
            return true;
        }
        return false;
    }

    public int getBig() {
        return big;
    }

    public int getMedium() {
        return medium;
    }


    public int getSmall() {
        return small;
    }


    public ArrayList<Integer> getPlanSignUp() {
        ArrayList<Integer> stu=new ArrayList<>();
        stu.add(1);
        stu.add(1);
        stu.add(2);
        stu.add(2);
        stu.add(2);
        stu.add(2);
        stu.add(3);
        stu.add(3);
        stu.add(3);
        stu.add(3);
        stu.add(3);
        stu.add(3);
        return stu;
    }

    public static IParams parse() throws Exception{
        return new SchoolSystem(3,6,9);
    };

    public static void main(String[] args) throws Exception {
        IParams params = SchoolSystem.parse();
        SchoolSystem sc = new SchoolSystem(params.getBig(), params.getMedium(), params.getSmall());
        ArrayList<Integer> plan = params.getPlanSignUp();
        for (int i = 0; i < plan.size(); i++) {
            sc.addStudent(plan.get(i));
        }
        for (int i = 0; i < plan.size(); i++) {
            System.out.println(sc.addStudent(plan.get(i)));
        }
    }
}
