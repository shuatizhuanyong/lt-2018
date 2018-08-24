class Solution {
    public void cleanRoom(Robot robot) {
        robot.clean();
        int i = 0;
        while (i++ < 4) {
            if (robot.move()) {
                cleanRoom(robot);
            }
            robot.turnLeft();
        }
    }
}
