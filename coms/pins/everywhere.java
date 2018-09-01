import java.util.*;
class Pin{
  public static Pin create(int id, int height) {
    Pin pin = new Pin(id, height);
    return pin;
  }
  int id;
  int height;
  public Pin(){}
  public Pin(int id, int height) {
    this.id = id;
    this.height = height;
  }
  public String toString() {
    return this.id + "";
  }
}
class Solution {
  
  public List<List<Pin>> layoutPins(List<Pin> pins, int colnums) {
    List<List<Pin>>  res = new ArrayList<>();
    if(pins == null || pins.size() == 0 || colnums <= 0) return res;
    Collections.sort(pins, new Comparator<Pin>() {
      public int compare(Pin p1, Pin p2){
        return p1.id - p2.id;
      }
    });
    
    PriorityQueue<PinCol> pq = new PriorityQueue<>(new Comparator<PinCol>() {
      public int compare(PinCol pc1, PinCol pc2) {
        return pc1.totalHeight - pc2.totalHeight;
      }
    });
    for (int i = 0 ; i < pins.size(); i++) {
      if (pq.size() < colnums) {
        PinCol pc = new PinCol();
        pq.offer(pc);
      } 
      PinCol curPc = pq.poll();
      curPc.ps.add(pins.get(i));
      curPc.totalHeight += pins.get(i).height;
      pq.offer(curPc);
    }
    while (!pq.isEmpty()) {
      res.add(pq.poll().ps);
    }
    return res;
  }
  
  class PinCol {
    int totalHeight = 0;
    List<Pin> ps = new ArrayList<>();
  }
  public static void main(String args[]) {
    Solution so = new Solution();
    List<List<Pin>> list = null;
    list = so.layoutPins(Arrays.asList(Pin.create(6, 300), Pin.create(2, 200), Pin.create(3, 110), Pin.create(4, 200), Pin.create(5, 100)),2);
    System.out.println(list);
  }
}
