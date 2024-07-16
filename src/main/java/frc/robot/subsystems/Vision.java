// package frc.robot.subsystems;

// import java.util.ArrayList;

// // TODO : Sample stolen from https://github.com/Lambda-Corps/2020InfiniteRecharge/blob/master/src/main/java/frc/robot/subsystems/Vision.java
// // Need to update to utilize the new Network Tables APIs as desccribed here: https://docs.wpilib.org/en/stable/docs/software/networktables/nt4-migration-guide.html

// import edu.wpi.first.networktables.NetworkTable;
// //import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class Vision extends SubsystemBase {
//   private final NetworkTable m_limelightTable;
//   private double tv, tx, ta;
//   private ArrayList<Double> m_targetList;
//   private final int MAX_ENTRIES = 50;
//   //private final NetworkTableEntry m_isTargetValid, m_led_entry;


//   /**
//    * Creates a new Vision.
//    */
//   public Vision() {
//     m_limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
//     m_targetList = new ArrayList<Double>(MAX_ENTRIES);
//     //m_isTargetValid = ShuffleboardInfo.getInstance().getTargetEntry();
//     //m_led_entry = m_limelightTable.getEntry("ledMode");
//   }

//   @Override
//   public void periodic() {
//     // This method will be called once per scheduler run
//     tv = m_limelightTable.getEntry("tv").getDouble(0);
//     tx = m_limelightTable.getEntry("tx").getDouble(0);
//     ta = m_limelightTable.getEntry("ta").getDouble(0);

//     //m_isTargetValid.forceSetBoolean(isTargetValid());

//     if (m_targetList.size() >= MAX_ENTRIES) {
//       m_targetList.remove(0);
//     }
//     m_targetList.add(ta);
//   }

//   public double getTX() {
//     return tx;
//   }

//   public double getTA() {
//     double sum = 0;

//     for (Double num : m_targetList) { 		      
//       sum += num.doubleValue();
//     }
//     return sum/m_targetList.size();
//   }

//   public boolean isTargetValid() {
//     return (tv == 1.0); 
//   }

//   public void setLlLedMode(int mode){
//     //m_led_entry.forceSetDouble((mode));
//   }
// }
