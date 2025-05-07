package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.JavaUtil;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MechanumTeleop (Blocks to Java)")
public class MechanumTeleop extends LinearOpMode {

  private DcMotor leftRear;
  private DcMotor leftFront;
  private DcMotor rightFront;
  private DcMotor rightRear;

  @Override
  public void runOpMode() {
    
    leftRear = hardwareMap.get(DcMotor.class, "leftRear");
    leftFront = hardwareMap.get(DcMotor.class, "leftFront");
    rightFront = hardwareMap.get(DcMotor.class, "rightFront");
    rightRear = hardwareMap.get(DcMotor.class, "rightRear");
		lifter = hardwareMap.get(Servo.class, "lifter");
		
    waitForStart();
    if (opModeIsActive()) {
			
      while (opModeIsActive()) {
        float speed = gamepad1.left_stick_y;
        float turn = gamepad1.right_stick_x;
				boolean aButton = gamepad1.a;
				boolean bButton = gamepad1.b;
				boolean xButton = gamepad1.x;
				boolean yButton = gamepad1.y;

				

        leftRear.setPower(speed + turn);
        leftFront.setPower(speed + turn);
        rightRear.setPower(speed - turn);
        rightFront.setPower(speed - turn);
      }
    }
  }
}
