# 2024-SwerveSample
First go at a swerve drive. 

Some notes:
- This is lifted directly from the Phoenix 6 CTRE Examples provided for the 2024 competition season. Before assuming this is exactly correct, should check if they've updated their samples.
- All motor and sensor CAN IDs need to either be changed to match the code, or the code constants changed to match the bot -- this needs to be done before any bench testing or other efforts actually executing code
- All constants in the TunerConstants.java file should also be checked as they are examples. The X/YPosInches constants all need to be adjusted for the chassis dimensions.
- This code does NOT scale anything -- with aggressive gear ratios and brushless Kraken X60 motors this drivetrain will be fast, perhaps terrifyingly so. Start slow and on bench before doing any floor testing
