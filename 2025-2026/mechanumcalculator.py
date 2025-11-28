import math as mafs
tilt = 45
tiltratio = mafs.sin(tilt)
presetdiameter = 104
presetvoltage = 12
presetSetPower = 1
presetRPMperVolt = 312/12

print("""-------------------
Mechanum Calculator
-------------------""")
diameter = int(input("Input diameter (-1 for preset): "))
voltage = int(input("Input current battery voltage (-1 for preset): "))
setpower = int(input("Input code's \".setPower()\" (-1 for preset): "))
RPM = int(input("Input motor speed at 12V (-1 for preset):"))
diameter = diameter if diameter != -1 else presetdiameter
voltage = voltage if voltage != -1 else presetvoltage
setpower = setpower if setpower != -1 else presetSetPower
RPM = RPM*voltage if RPM != -1 else presetRPMperVolt*voltage

circumference = (diameter * mafs.pi)

print("Counting\n\n")
print(f"""Mechanum wheel diameter is approximately {circumference:.5f}.
That means the movement for each 1 revolution is and assuming no load;
Forward movement: {circumference * tiltratio:.5f}
45 degree movement: {circumference:.5f}

Speed assuming no load:
Current battery voltage is {voltage}, and the code has \".setPower({setpower})\".
With these conditions, wheel and the motor can move at a forward speed of {(circumference * tiltratio) * RPM:.5f}mm per minute,
or {(circumference * tiltratio) * RPM / 60:.5f}mm per second
But in m notation, wheel and the motor can move at a forward speed of {((circumference * tiltratio) * RPM)/1000:.2f}m per minute,
or {((circumference * tiltratio) * RPM / 60)/1000:.2f}m per second""")