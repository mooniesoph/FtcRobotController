package org.firstinspires.ftc.teamcode; // Replace with your team's package name

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "ServoTeleOp", group = "TeleOp")
public class Servos extends OpMode {

    private Servo servo;
    private Servo servo2;

    private double servoPosition = 0.5; // Initial servo position
    private double servoPosition2 = 0.5;


    @Override
    public void init() {
        // Replace "servoName" with the actual name of your servo in the configuration
        servo = hardwareMap.get(Servo.class, "jeff");
        servo2 = hardwareMap.get(Servo.class, "rebecca");
    }

    @Override
    public void loop() {
        // Use the joystick to adjust the servo position
        double joystickInput = -gamepad1.left_stick_y; // Adjust this based on your controller's joystick axis
        double joystickInput2 = -gamepad2.left_stick_y;
        double positionIncrement = 0.01; // Adjust the increment based on your preference

        servoPosition += joystickInput * positionIncrement;
        servoPosition2 += joystickInput2 * positionIncrement;

        // Limit the servo position between 0 and 1
        servoPosition = Math.max(0.0, Math.min(1.0, servoPosition));
        servoPosition2 = Math.max(0.0, Math.min(1.0, servoPosition2));

        servo.setPosition(servoPosition);
        servo2.setPosition(servoPosition);

        // Display servo position on telemetry
        telemetry.addData("Servo Position", servoPosition);
        telemetry.update();
    }
}
