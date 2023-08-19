package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class DriveTrain extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // initialize & config motors
        DcMotor fLeft = hardwareMap.dcMotor.get("fLeft");
        DcMotor bLeft = hardwareMap.dcMotor.get("bLeft");
        DcMotor fRight = hardwareMap.dcMotor.get("fRight");
        DcMotor bRight = hardwareMap.dcMotor.get("bRight");

        // set motor directions. positive power is forward.
        fLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        bLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        fRight.setDirection(DcMotorSimple.Direction.REVERSE);
        bRight.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart(); // Wait for the start button to be pressed

        while (opModeIsActive()) {
            double forwardMovement = -gamepad1.left_stick_y;  // forward joystick is -(-1) = +1

            fLeft.setPower(forwardMovement);
            bLeft.setPower(forwardMovement);
            fRight.setPower(forwardMovement);
            bRight.setPower(forwardMovement);
        }
    }
}
