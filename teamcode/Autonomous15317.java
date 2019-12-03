/*
Copyright 2019 FIRST Tech Challenge Team 6383

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Gpsbrain;
import org.firstinspires.ftc.teamcode.Drive;
import org.firstinspires.ftc.teamcode.Collect;
import org.firstinspires.ftc.teamcode.Find;


@Autonomous

public class Autonomous15317 extends LinearOpMode {

    private Drive d;
    private Collect c;
    private BNO055IMU imu;
    private Gpsbrain gps;
    private Find f;

    @Override
    public void runOpMode() {

        d = new Drive(
          hardwareMap.get(DcMotor.class, "rbmotor"),
          hardwareMap.get(DcMotor.class, "rfmotor"),
          hardwareMap.get(DcMotor.class, "lfmotor"),
          hardwareMap.get(DcMotor.class, "lbmotor")
      );

        // c = new Collect(
        // );
        
        f = new Find(
                //hardwareMap.get()
            );

        imu = hardwareMap.get(BNO055IMU.class, "imu");

        gps = new Gpsbrain(d, imu, c, f);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        
        //For testing, push operation here:
        gps.state = "seek";
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            gps.update();
            
            telemetry.addData("State", gps.state);
            telemetry.addData("clicks", d.getClickslf());
            telemetry.update();

        }
    }
}
