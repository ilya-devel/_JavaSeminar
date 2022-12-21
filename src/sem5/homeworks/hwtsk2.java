package sem5.homeworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hwtsk2 {
    public static void main(String[] args) {
        String[] paths = new String[]{"root/qgjazhtliq/djmevsktisuvd/acsuolhnermqzok/mkts/ibrdqxawjgut/emb wl.txt(odumfqzwczehoyk) z.txt(gojsklotgchjzfm) txtoyg.txt(gojsklotgchjzfm) eupidhefx.txt(ahlsazuzrsf) rekzkaifwp.txt(yfxaymkefaofowqjpgaceffkjsehtmqkgy) l.txt(odumfqzwczehoyk) bqmhpxumxlbe.txt(yfxaymkefaofowqjpgaceffkjsehtmqkgy) qoqgiauqbayuc.txt(odumfqzwczehoyk) mpstemqlxy.txt(ahlsazuzrsf)"};
        List<List<String>> duplicate = findDuplicate(paths);
        System.out.println(duplicate);
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> lstKey = new HashMap<>();
        for (String path: paths) {
            String[] tmp = path.split(" ");
            for (int i = 1; i < tmp.length; i++) {
                String[] fileWithData = tmp[i].split("\\(");
                String data = fileWithData[1];
                String file = fileWithData[0];
                if (lstKey.containsKey(data)) {
                    List<String> newPath = lstKey.get(data);
                    newPath.add(tmp[0] + "/" + file);
                } else {
                    List<String> addData = new ArrayList<>();
                    addData.add(tmp[0] + "/" + file);
                    lstKey.put(data, addData);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key: lstKey.keySet()) {
            if (lstKey.get(key).size() > 1) result.add(lstKey.get(key));
        }
        return result;
    }
}
