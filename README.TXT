--PLEASE SEE USER MANUAL BEFORE READING THIS DOCUMENT--

Project Title: AJAY Tower Defense
Authors: Jeffrey Wang, Aaron Liao, Alex Wang, Yunjun Kim
Version: 1.0 (2012-06-12)
Notes:
- Compiling while the program is still running may cause the music to continue playing even after the screen is closed. No errors result in this however.
- Tower stacking is intentional
- Towers cannot be placed on the path or on the cut-off bottom-most row (intentional)
- Bullet pathing is buggy and erratic (unintentional)
- BlackBullet may hit a minion two or three times unintentially

Changelog:

[1.0]
- Removed sound start menu
- Added sound toggles in both menu and game screen

[0.3.0]
- Commented code
- Auto-indented code
- Balance changes
- Fixed bug in which advancement of the selection screens would occur upon a click anywhere on the screen

[0.2.5]
- Balance changes

[0.2.4]
- Added difficulty option

[0.2.3]
- Added option for sound
- Moved images to images folder

[0.2.2]
- Removed experimental instance variables in Screen
- Balance changes

[0.2.1]
- Balance changes

[0.2.0]
- BETA STAGE
- Basic framework complete
- Menu framework complete
- Music added to intro screen

[0.1.5]
- Radiation tower now works as intended

[0.1.4]
- Changed all MouseEvents to respond only to MOUSE1 button

[0.1.3]
- Menu framework added

[0.1.2]
- Balance changes
- Bullet flickering reduced
- Wave system now modular. To add waves, modify the Wave class.

[0.1.1]
- Modified tower costs and minion waves to fit with speed of the game

[0.1.0]
- ALPHA STAGE
- Game is now playable

[0.0.1.3]
- Bullet hit detection and minion death complete

[0.0.1.2]
- Updated images
- Created game over and end game images

[0.0.1.1]
- Wave system ArrayList adding issue fixed

[0.0.1.0]
- Entire Wave system now complete!

[0.0.0.8]
- Updated images

[0.0.0.7]
- Wave information added

[0.0.0.6]
- Multiple towers now placeable
- Note 1 deleted as placement flaw was fixed

[0.0.0.5]
- 1 Tower now placeable (see Note 1)

[0.0.0.4]
- Tower buttons now clickable and moveable (not yet placeable)
- New images added
- New classes: Gold, Life, Level, Bullet
- New tower classes
- Minion and Tower interfaces changed to abstract classes

[0.0.0.3]
-Created a visual representation of minions going down path.
-Did not use any tutorials so process is one hundred percent original.

[0.0.0.2]
- Store: Writing text
- New classes (implements Minion): Red, Orange, Yellow, Green, Blue, Purple

[0.0.0.1]
- Finalized map shown on screen
- Terminal Window now outputs presses at store buttons
- Store: Buttons updated to show towers
- Store: "Gold" and "Heart" icons added