package frc.robot;

import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Autos;
import frc.robot.commands.DrivetrainCommand;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
  private final PathPlannerTrajectory Path = PathPlanner.loadPath("New Path",4,3);
  private final Joystick right = new Joystick(0);
  private final Joystick left = new Joystick(1);
  private final Drivetrain m_drivetrain = new Drivetrain();

  public RobotContainer() {
    m_drivetrain.setDefaultCommand(new DrivetrainCommand(
            m_drivetrain,
            () -> Math.pow(right.getY(), 3) * Constants.MaxSpeed, // Y
            () -> Math.pow(right.getX(), 3) * Constants.MaxSpeed, // X
            () -> Math.pow(-1 * left.getTwist(), 3) * Constants.MaxTurnSpeed, // Z
            () -> {
              return true;
            } // Feild Orinted

    ));

    configureButtonBindings();
  }
  private void configureButtonBindings() {



  }

  public Command getAutonomousCommand() {
    // PIDController Xcontrlor = new PIDController(Constants.Auto.K_XController,0,0);
    // PIDController YControlor = new PIDController(Constants.Auto.K_YController,0,0);
    // ProfiledPIDController thetaController = new ProfiledPIDController(
    //         Constants.Auto.K_RController, 0,0, new TrapezoidProfile.Constraints(4,3)
    // );

    // thetaController.enableContinuousInput(-Math.PI, Math.PI);
    // Trajectory PathTrajectory = new Trajectory(Path.getStates());

    // SwerveControllerCommand swerveControllerCommand = new SwerveControllerCommand(
    //         PathTrajectory,
    //         m_drivetrain::getpos,
    //         Constants.m_kinematics,
    //         Xcontrlor,
    //         YControlor,
    //         thetaController,
    //         m_drivetrain::setModuleStates,
    //         m_drivetrain
    // );
    // return swerveControllerCommand;
    return Autos.forward(m_drivetrain);
  }
}
