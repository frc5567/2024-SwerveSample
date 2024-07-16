package frc.robot.constants;

import frc.robot.helpers.Gains;

public class RobotMap {

    public static class DrivetrainConstants {

        // Front Left
        public static final int FRONT_LEFT_DRIVE_ID = 11;
        public static final int FRONT_LEFT_STEER_ID = 8;
        public static final int FRONT_LEFT_ENCODER_ID = 14;
        public static final double FRONT_LEFT_OFFSET = 0.328125;

        public static final double FRONT_LEFT_XPOS_INCHES = 9.375;
        public static final double FRONT_LEFT_YPOS_INCHES = 8.375;

        // Front Right
        public static final int FRONT_RIGHT_DRIVE_ID = 10;
        public static final int FRONT_RIGHT_STEER_ID = 7;
        public static final int FRONT_RIGHT_ENCODER_ID = 15;
        public static final double FRONT_RIGHT_OFFSET = 0.352783;

        public static final double FRONT_RIGHT_XPOS_INCHES = 9.375;
        public static final double FRONT_RIGHT_YPOS_INCHES = 8.375;

        // Back Left
        public static final int BACK_LEFT_DRIVE_ID = 5;
        public static final int BACK_LEFT_STEER_ID = 9;
        public static final int BACK_LEFT_ENCODER_ID = 13;
        public static final double BACK_LEFT_OFFSET = 0.341309;

        public static final double BACK_LEFT_XPOS_INCHES = -9.375;
        public static final double BACK_LEFT_YPOS_INCHES = 8.375;

        // Back Right
        public static final int BACK_RIGHT_DRIVE_ID = 6;
        public static final int BACK_RIGHT_STEER_ID = 4;
        public static final int BACK_RIGHT_ENCODER_ID = 12;
        public static final double BACK_RIGHT_OFFSET = -0.142578;

        public static final double BACK_RIGHT_XPOS_INCHES = -9.375;
        public static final double BACK_RIGHT_YPOS_INCHES = -8.375;

        /**
         * CAN ID of the Pigeon
         */
        public static final int PIGEON_CAN_ID = 3;

        public static final double DRIVE_GEAR_RATIO = 6.75;
        public static final double STEER_GEAR_RATION = 21.4285;

        public static final boolean STEER_MOTOR_REVERSED = true;
        public static final boolean INVERT_LEFT_SIDE = false;
        public static final boolean INVERT_RIGHT_SIDE = false;

        public static final Gains STEER_GAINS = new Gains(100.0, 0.0, 0.05, 0.0, 1.5, 0.0);

        public static final Gains DRIVE_GAINS = new Gains(3.0, 0.0, 0.0, 0.0, 0.0, 0.0);

        // Theoretical free speed (m/s) at 12v applied output;
        // This needs to be tuned to your individual robot
        public static final double SPEED_AT_12V_MPS = 5.0;

        public static final double MAX_SPEED = SPEED_AT_12V_MPS; // kSpeedAt12VoltsMps desired top speed
        public static final double CRAWL_SPEED = 1.0;
        public static final double MAX_ANGULAR_RATE = 1.5 * Math.PI; // 3/4 of a rotation per second max angular velocity

        public static final double DRIVE_DEADBAND = 0.1;
        public static final double ROTATE_DEADBAND = 0.1; 
    }

    /**
     * All Pilot Controller constants.
     */
    public static class PilotControllerConstants {

        /**
         * USB port number of the xbox controller.
         */
        public static final int XBOX_CONTROLLER_USB_PORT = 0;

        /**
         * Absolute value of the deadband range for stick input.
         */
        public static final double STICK_DEADBAND = 0.09;

        /**
         * Adjusts output of turns to tone down the final output.
         */
        public static final double TURN_SCALAR = 1.0;

        /**
         * Rate limit for acceleration to prevent brownouts.
         */
        public static final double ACCEL_SLEW_RATE = 3.0;
    }
}
