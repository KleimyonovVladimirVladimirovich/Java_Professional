package kleimyonov;

import com.thoughtworks.qdox.model.expression.GreaterThan;

import java.util.List;

public class DataService {
    public String some(int a,int b) {
        int result = a * b + 1;
        return String.valueOf(result);
    }
    public List<String> getAllData() {
        return null;
    }
    public int getSquare(int c) {
        return 1;
    }
//     public DataService() {
//        throw new IllegalArgumentException();
//     }

    public getInner getSomeInnerClass() {
        return new getInner();
    }
     static class getInner {
        public getInner getSomeInnerClass() {
            return new getInner();
        }
     }
}
