# 2024-SwerveSample
First go at a swerve drive. 

Some notes:
- Code is based on CTRE Sample for Command-Based Swerve Drive. We've modified to make the Teleop Command and demonstrate how the Bindings work more clearly with Commands and Subsystems
- All motor and sensor CAN IDs have been set and moved to the RobotMap format. Keeping the TunerConstants.java file for now.
- Need to execute kinematics to truly capture the nature of the bot, but Odometry is already functional with the built-in capabilities and guesses at some values.
- Controls are swerve control:
  - Left stick moves the bot in whatever direction the stick moves.
  - Right stick X-axis rotates the bot about it's center.
  - Left Bumper resets "forward" (up on left stick) to be whatever direction the bot is facing.
  - A Button Brakes
  - B Button points swerve modules in whatever direction the left stick is moved (good for bench testing modules)
- Autons will be designed using [http://PathPlanner.dev/](http://PathPlanner.dev/). Paths and autons can be found in the deploy folders, and are in JSON format. Ideally we only use the tool to edit. More learning to come
- Simulation should fully work with this code.
  - If you happen to uncheck the "Map Gamepad" checkbox in the sim, the XBox Controller axes are wrong -- make sure it is checked!
  - Starting bot position is default for now - still looking into how to start in a reasonable position
  - There is no boundary/collision detection in the sim - not really realistic
  - We don't yet know how to fully simulate mechanisms, although it is possible. 
