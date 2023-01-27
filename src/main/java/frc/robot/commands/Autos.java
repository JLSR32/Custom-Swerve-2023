// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Drivetrain;


public final class Autos
{
    public static Command forward(Drivetrain m_drivetrain){

        return Commands.sequence(
                
            new DrivetrainCommand(
                    m_drivetrain,
                    () -> .05, // Y*speed
                    () -> .0, // X*speed
                    () -> .0, // Z*speed
                    () -> {
                      return false;
                    } // Feild Orinted)
                ),
        
        new WaitCommand(10),

        new DrivetrainCommand(
            m_drivetrain,
            () -> .0, // Y*speed
            () -> .0, // X*speed
            () -> .0, // Z*speed
            () -> {
              return false;
            } // Feild Orinted)
        ));
    }



    private Autos()
    {
        throw new UnsupportedOperationException("This is a utility class!");
    }



    


}
