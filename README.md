# SC2002 Group Project: Camp Application and Management System (CAMs)

## Overview
Our assignment is to design and develop a Camp Application and Management System (CAMs). CAMs is a centralized application for staff and students within NTU to manage, view, and register for camps.

## Features

### For all users
- **Profile Management**: Users can change passwords, and view their own profiles which display their information.

### For Students
- **Camp Registration**: Students can easily view and register for available camps, their own faculty camps, or NTU-wide camps. They can withdraw from camps registered as attendees. One cannot sign up for camps with clashing dates.
- **Camp Committee Membership**: Students have the option to sign up as a Camp Committee Member.
- **Inquiries and Suggestions**: Students can submit and manage their own inquiries by viewing, editing, or deleting them. They can submit multiple inquiries related to the same camp.

### For Camp Committee Members
- **Camp Registration**: Once signed up as a member, cannot withdraw from a camp. They can still sign up for camps as attendees as long as the dates do not clash.
- **Camp Management**: Camp Committee Members can generate camp-specific filtered reports. They can submit, edit, view, and delete their suggestions regarding the camp. They will be rewarded points based on their submissions for suggestions and replies to inquiries, as well as, additional points if their suggestions have been approved by the staff.
- 
### For Staff
- **Camp Management**: Staff can generate camp-specific filtered reports. They can create, edit, and delete their personal camps. Staff can also view all other camps created by other staff members.
- **Inquiry and Suggestion Management**: Staff can reply to suggestions and inquiries, approve suggestions, and reward points accordingly.

## Security
Security measures such as secure log-in and log-out have been implemented.

## Error handling
Different bugs have been handled and accounted for. Error checking has also been implemented in terms of wrong inputs by the user such as keying in wrong dates, or wrong type inputs.

## Code Quality
We have ensured Diagram to Code correctness, readability, adherence to Java naming convention, exception handling, and completeness of Java Doc.

## User Experience
The application has been designed with a focus on user-friendliness, flow, and innovation, providing broad coverage of application essentials and functionalities. A design on the main menu page has also been implemented to showcase the CAMs.
