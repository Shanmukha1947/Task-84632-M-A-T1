import java.util.ArrayList;
import java.util.List;

public class ARObjectSimulator {

    private List<ARObject> arObjects = new ArrayList<>();

    public void addARObject(ARObject arObject) {
        arObjects.add(arObject);
    }

    public void simulate(float deltaTime) {
        for (ARObject arObject : arObjects) {
            arObject.update(deltaTime);
        }
    }

    public static class ARObject {
        private float positionX;
        private float positionY;
        private float rotationZ;

        public void update(float deltaTime) {
            // Simulate simple position and rotation updates
            positionX += deltaTime * 0.1f;
            positionY += deltaTime * 0.1f;
            rotationZ += deltaTime * 0.5f;
        }

        // getters and setters
    }

    public static void main(String[] args){
        ARObjectSimulator simulator = new ARObjectSimulator();
        simulator.addARObject(new ARObject());
        simulator.addARObject(new ARObject());

        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            simulator.simulate(0.01f);
        }
        long endTime = System.nanoTime();

        double duration = (double) (endTime - startTime) / 1_000_000;
        System.out.println("Simulation duration: " + duration + " ms");
    }
}
