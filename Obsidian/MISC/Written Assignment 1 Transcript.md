SPEAKER
SPEAKER: Computer science modules, reliability and liability prepared by the Inamori International Center for
Ethics and Excellence, including Dr Daniel Rosiak,
Professor Shannon E French and Beth Trecasa. It is difficult to overstate how
dependent we are today on computers and computerized systems to facilitate
so many of our daily activities. Such systems now govern most of
modern communication, transportation, finance, retail, health care,
military systems and more. When computerized systems work
correctly, they can of course save us time, money and enable the accomplishment
of many other activities. But when they fail
or something goes wrong, any of those benefits can
quickly be overturned by rather disruptive or impactful harms. Failures of computer integrated
systems can ramify throughout many areas of society
resulting in lost time, lost money, social injustice
and even injury or loss of life. Computers and code nearly
always form part of larger systems like financial systems,
health care systems, transportation systems etcetera
and fundamentally it is the reliability of the entire
system that is most important. A system that is designed well is one
that can tolerate the malfunction of any single component without
feeling or causing harm. These two paired modules are designed
to familiarize you with some of the ways in which computerized systems
have proven to be unreliable. What we can do to make them more
reliable, what the broader ethical stakes are, and general practices we can implement
to encourage greater awareness and anticipation of the risks. We have some specific objectives. The main purpose of this
two part reliability and liability module is to keep... is to invite inspiring computer scientists and others involved in the construction, design, upkeep and testing of
large systems or components. Thereof to increase their awareness
of some of the broader ethical risks associated with a variety
of ways things can go wrong. Module one includes a number
of carefully selected examples to illustrate
three main error types. Important lessons drawn from each of
those examples and an assignment for students. Module two some general tools to better identify and mitigate ethical risks, another assignment for students
and further reading and resources. SPEAKER: Alright, so for
the first set of examples, we're going to look at instances
where the user or computer human interface turns out to be
the weak link in the system, leading to some sort of
issue or some problem. We can call these issues the system errors due to data entry or data retrieval. So this is just what it sounds like. Sometimes computerized systems
fail or behave in unexpected ways as a result of wrong data
having been entered into them, or because people incorrectly
interpret the data they retrieve. So it is tempting to want to focus
on a particular mistake made by an individual person
and bring retrieving the data. But we should instead keep in mind
that any system like, for instance, the voting system failing
after incorrect records inputted into the computer
database disqualified thousands of voters or like
the criminal justice system, failing when a person is
arrested after being confused with another person in
a database that any system, the idea here is we should keep
in mind that any system is larger than the individual person
or persons who make the error, thus it's often more useful
to focus on how such local error errors are possible
in the first place, how they are allowed to
propagate through a system to become more larger impact problems, and how to anticipate and mitigate
the risks associated with this. So for the first example,
we're going to be looking at the National Crime
Information Center database, so the FBI's NCIC is
a computerized database of criminal justice information made
available to federal, state and local law enforcement and other criminal justice agencies for access by various criminal justice agencies
making some sort of inquiry. The information in this
database is designed to assist authorized agencies in their law enforcement objectives,
such as apprehending fugitives, locating missing persons,
looking at criminal records, locating and returning stolen
property and this sort of thing. Tens of thousands of law
enforcement agencies have access to these data files and the NCIC processes
more than 13 million requests for information every day. As an example of how this might be used, a police officer may initiate
an NCIC search during a traffic stop to find out if the vehicle has been stolen or if there is
a warrant out for the driver and the system will then supply records
and answers to such queries. A number of critics of the NCIC though, have pointed out ways in which this system has led to a variety of injustices and privacy violations of innocent people. Such as for instance, erroneous
records entered into the database, leading law enforcement agencies
to arrest innocent persons, typographical errors made
by law enforcement checking the database leading to false arrests. Innocent people with the same name
as that of individuals listed in the Arrest Warrants Database being
mistakenly arrested and corrupt law enforcement employees
with access to this database having sold information altered, deleted or otherwise misused records. For just a few concrete instances of
the many stories of police making false arrests based on information
that they retrieved from the NCIC. Here are two notable ones. So (UNKNOWN) was jailed
twice in three years as a suspect in a Chicago
residential burglary, even though he had never
been to Chicago in his life. The authorities had confused him
with another (UNKNOWN) during a single entry due to
a single entry in the NCIC. The two (UNKNOWN) were the same
height, about the same weight, had brown hair, brown eyes,
tattoos on their left arm, shared the same birthday
and had Social Security had Social Security numbers that
differed by just one digit. Another example is (UNKNOWN)
ended up being arrested five times and twice at gunpoint
for crimes he didn't commit. The NCIC had erroneously listed him
as wanted for murder and robbery even after the actual suspect using
his name had been identified. OK, so for a second example of this
errors of this particular type, we'll look at Amazon AWS crash. So on February 28, 2017,
the Amazon AWS service crashed causing many websites hosted by
the software to become unresponsive. Amazon conducted an internal
investigation and concluded that during
a simple debugging, a single service member had executed
a single command intended to remove a negligible amount of servers
to help speed up the process. While Amazon was in the end able
to restore service fairly quickly and no data was permanently lost, it was reported that
S&P 500 companies lost an estimated $150 million and U.S. financial services service companies
lost even more during the outage. So a lot of economic damage from
entering a simple command incorrectly. For the final example of this type, we'll look at the Hawaii missile
alert from a couple of years ago. So Hawaii, just a little
bit of background here. Hawaii is the only state
with a pre-programmed wireless emergency alert that can be sent directly to wireless
devices if a ballistic missile is headed toward the state. This is partly because
if a missile were ever fired from North Korea, for instance, the missile would take approximately
just 20 minutes to reach Hawaii. And on the right there,
this is what the emergency alert looks like on a phone
to residents of White. So 2018 there had been inadvertently
sent out by an employee of the Emergency Management
Agency during a shift change. During that change the...a
supervisor initiated an unscheduled drill in which he contacted emergency management
workers in the guise of an officer from the U.S. Pacific Command. The supervisor deviated from
the script at one point saying, "This is not a drill", although he did state both before
and after that message exercise, exercise, exercise to indicate
that it was in fact a test. But upon hearing
the supervisors statement, the employee assuming their post during the shift change right after the shift change believed that there was
an actual emergency and proceeded to click the alert button
from a dropdown of options, which would then send out
an actual notification on Hawaii's emergency alert interface to
all the residents of Hawaii. The employee then clicked
through a second screen, which had been intended as
a safeguard to confirm. And this created a lot of widespread
panic throughout residents, and a number of a lot
of damage was caused. For instance, one particular
resident had a heart attack after seeing this
and ended up passing away. So Hawaii emergency
management agency officials were subsequently asked for a screenshot of the interface the employee was looking at when the false alert was sent out. They gave a facsimile
of the user interface, not the actual screen
for security purposes, but something that they said was
very similar to what they had. And a number of people
criticized the archaic design, logic and layout of this UI. You can see an example of this
in a graphic to the right. So the DRILL-PACOM (DEMO)-STATE
ONLY link, was the link the employee was meant
to have clicked on for a test, but listed below that
the PACOM (CDW)-STATE ONLY the link that he did in fact click, was the one that led to
the incoming ballistic missile alert sent to residents
and visitors statewide. And as this person points out,
this is not the kind of interface you'd expect to see for
something this important. OK, so generally speaking, from
the perspective of those responsible for well engineered systems and
the code elements of such systems, it may appear and may indeed
be the case that certain aspects of such user
errors are inevitable. The proper response to these
things may indeed largely depend on the proper
training of human users. But as ethically responsible
coders, computer scientists, there are still general
principles that we can adopt that will allow us to do all that
we can to avert such errors, or at least minimize
and to anticipate and minimize the harmful effects of
such unfortunate cases. So the main lesson here for this
particular set of examples, for the first error type, we can adopt a modified version
of an insight from (UNKNOWN). So don't think of
the user as making errors. Think of the actions as approximations of what the system itself intends. And anticipate and build into
the system tolerances and safeguards to the potential errors
in such approximations. And remember that a well
engineered system does not fail when a single component fails. So if there are ways a single
human user can cause large scale deviations from intended
use or negative effects, the effects of such local deviations on the broader system should be anticipated, minimized and safeguarded
against as much as possible. OK, so we're gonna now move
into errors of the second sort. And just a general reflection first, that these errors of
the first type of data entry or retrieval can be quite harmful or can have a pretty disastrous
effects in certain cases. However, it does seem to be the case that their analysis is typically comparatively uncomplicated and the measures we
can take are often straightforward. But even assuming data
entered into or retrieved from a computer system are correct. So there's no problem in the first
sense of how things can go wrong. The system may still produce
long or undesirable results, and they even collapse entirely
if the errors are serious enough. So in those cases, we can identify
the other two main sorts of errors, and that would be the errors, bugs or code features that enable system malfunction and something more severe. In the third case, errors, bugs or code features enabling system failure. The ethical risks and liabilities of these two latter sorts of errors are generally harder to mitigate and or involve
the greatest potential for harm. So we're gonna look in more
detail at this second...these latter two sorts of errors. So first, the errors, bugs,
enabling system malfunction, we're gonna look at three examples here. The first just one having to do with spell check and the second high risk inmates mistakenly released and the third
a an instance of rent miscalculation. SPEAKER: Example one spellcheck,
the University of Pittsburgh study revealed that for most students, computer spelling and grammar
error checkers actually increased the number of
errors that students made. Example two, high risk
inmates mistakenly released. In 2010, in the course of
implementing a program meant to lessen prison overcrowding, more than 400 California prison
inmates classified as high risk of violence were mistakenly
released owing to computer errors. An additional 1,000 prisoners
deemed to present a high risk of committing other
crimes were also let out, stemming from those same errors. None of the prisoners could
be returned to prison or retroactively put on supervised parole, as they had already been
granted non revocable parole. Under the law that created
non revocable parole, inmates are excluded
if their gang members have committed sex crimes or
violent felonies, or have been determined to pose
a high risk to re-offend based on an assessment of their
records while incarcerated. The computer program that
prison officials use to make that assessment did that. It actually could not access
an inmates disciplinary history. The program also relied on
a state level Department of Justice system that record
arrests that was missing. Conviction information for nearly half of the state's millions of arrest records. Example three, rent miscalculation.
Between September 2008 to May 2009, hundreds of low income
families living in public housing in New York City
were charged too much, too much rent because
of the computer error. Specifically an error in the program
that calculated monthly bills. For those nine months, the New York
City Housing Authority ignored the complaints made by the renters
that they were being overcharged. Instead, it took to court
and threatened with eviction those who failed to make
the higher payments. Lessons learned.
Lesson one, avoid automation bias, we see this in spellcheck
and rent miscalculation. Automation bias is a term often used
to describe our documented habit favoring or deferring to
suggestions coming from automated decision making systems and programs to the point of ignoring contradictory information from sources
not deploying automation. Even when that information is correct, our tendency to be positively
biased toward the results of the automated system component has
been a growing problem for decision making. Many high impact areas
like intensive care units, nuclear power plants and Aircraft control have increasingly
integrated computer system components and decision aids that are designed
to factor out possible human error. Lesson two. Ensure that the program has all
the relevant data in the first place, not just that it operates
correctly with any data, it is already assumed to have. We see this in Inmate's Release. Sometimes the failures of a program
to query certain data can in the broader context of the way
the program is used lead to flaws, in the implementation of
the program, in its native context use. Be sure not to just check
the program in terms of how it operates with the data
it has at the code level, but also to consider whether
the program itself is calling on all the relevant data it needs in order
to be implemented correctly, or appropriately,
in the broader context of use. In section three, we'll
look at errors and bugs, enabling system failure. SPEAKER: So we're gonna look at six
examples, and get into a little bit more depth with some of these,
especially example five and six. We'll look at the Boeing 737 MAX crash, the Tesla 2016 crash Patriot
missile system, the Ariane 5, explosion and robot mission
tomorrow's example five, and flash crashes and financial markets. So for the first example,
the Boeing 737 MAX crash. So, this concerns
an event on October 29th, 2018 when a Boeing 737 MAX airplane
flying from Jakarta crashed into the Java Sea just 13
minutes after takeoff, which took the lives of
189 passengers and crew. Subsequent investigations
revealed flight control problems, failures of something called
the angle of attack sensor. And other failures tied to a design flaw in the core system of the MAX series. Less than six months later, in 2019, another 737 MAX crashed only
six minutes after takeoff, taking the lives of all
157 people on board. So the National Transportation
Safety Committees, the NTSC, issued a report
after this, and they... In that report, they list
nine contributing factors, the most serious of which seems to be
nose pertaining to the angle of attack sensor, and assumptions that
were made about flight crew response to malfunctions. Even though those
assumptions were consistent with current industry guidelines, they turned out to be incorrect. So, in terms of the angle of attack, angle of attack concerns
the relative angle between airflow and airplanes orientation. When an aircraft is in flight mode, the angle at which it lifts increases, and thus the lift force increases as well. But the plane's weight
remains constant, of course, so the pilot has to
then increase the angle of attack as the airplane slows. But if the airplane
continues to slow down, as the angle of attack increases, it will stall and this
may lead to a crash. So, the planes have sensors located on either side of the nose and cockpit. And this would alert the pilot
to the current angle of attack, the sensors provided,
they are working properly. Obviously, pilots need accurate
measurements of this angle, which the sensors are there to provide. For the 737 MAX, a safety measure
was built into the automated flight control system
that reduces the angle of attack by turning the nose
down when it senses that the angle is very high
and approaching stall conditions. So this particular issue
with this angle of attack sensor was one of the chief
causes of the crash. So, as a flight expert would explain, in the two recent Boeing 737 MAX
crashes, it appears that the sensor
sent wrong information to the flight control system indicating the angle of attack is
too large and approaching stall. So the system steered
the aircraft by pitching the nose down to correct
the angle of attack. The pilots realized that
this was a wrong command and they tried to override the system, but appears they could not
figure out how to override it. So the planes went into
a dive and eventually crashed. We are not at the face where pilots
should be left out of the cockpit. We think pilots should
still fly the airplanes. Those two accidents are
not due to poor design, it's more because of
a judgment call in programming, a small error that made such a big impact. OK, so for the second example
here, the Tesla crash, this refers to an event in 2016,
on March - sorry May 7, 2016, when Joshua Brown was driving his
Tesla on a highway and was killed after crashing into a semi trailer
portion of truck on the highway. The accident occurred as
Brown's Model S with autopilot engaged was traveling east
on a divided highway. The truck had been traveling
in the opposite direction on the highway and turned
left in front of the Tesla. But the semi trailer portion was
elevated enough off the ground so that the car continued under
it shearing off its roof, after which the Tesla was
sent veering off the road. So, some background here that after 2014, Tesla started equipping its
cars with autopilot software, that enabled the car to control
its speed and steer in this included also an automated
emergency braking or AEB system. The Tesla claimed that
the driver should use this autopilot when the conditions are clear. And there was the expectation that
the human driver will respond appropriately to any requests
of the vehicle to intervene. And they claimed the driver
is still responsible for and ultimately in control of the car. After Brown's crash in
2016, the subsequent NTSB investigation determined that autopilot was engaged for
37 minutes before the collision, during which time Brown's hands were on the steering wheel for only 25 seconds, and he received seven
visual and audible warnings to put his hands back
on the steering wheel. But Brown had responded to each of
these warnings by putting his hands on the steering wheel for between
just one and three seconds. As for the AEB system, when
the truck turned in front of the Tesla and Brown failed to
respond, why did this not engage? So, Mobileye who supplied
the vision system for autopilot provided the explanation that the system was designed to avoid rear-end collisions, but not to avoid vehicles
crossing laterally. However, after Mobileye
issued that statement, Tesla quickly released
a quote-unquote clarification, and which are noted its autopilot system relies on dozens of technologies to determine how it should respond
to a particular situation. According to Tesla, automatic braking did not engage because the trailer was white, which made it difficult to
see against the background, and the trailer was also
very tall making the radar confused actually for an overhead cycle. OK, so, in terms of the lessons learned from these first two examples here, we can draw perhaps three lessons. So, the first is, in the case of
automated components of a system, even seemingly reasonable
assumptions about the expected behavior
of human operators in the face of both malfunctions and
ordinary operation should be carefully scrutinized, and one thinks of the MAX 737 example
here but also the Tesla autopilot incident. So, the second lesson. Smooth transition passing control
between automated control and human operation should
be carefully considered, both at the level of
code and system design. To elaborate on this if,
if operators such as pilots, drivers do not place enough
trust in an automated system, they might inject risk by
intervening in system operation. But conversely, if pilots trust
that automated system too much, then they either suffer
from automation bias and fail to intervene when necessary, or lack sufficient time to act
once they identify a problem. While clear transitions
back to human control or manual override should
be built into systems, experts have noted how in
many emergency situations. There's something may not be
enough time for a human operator to retake control before
an accident occurs. Thus, in general, we can say this, automated control systems should
be designed in such a way that well humans always can take
over in an emergency situation, humans have never needed to take over
in any such emergency situation. For the third lesson,
sensor misinformation, as with the angle attack or edge
cases involving misidentification, as with the Tesla sensor,
make mistaking the trailer portion of the truck for a sign, need
to be considered in advance. So these edge cases, these unexpected
or undesired cases of sensor information needs to be thoroughly
considered that in advance and code level mechanisms
put in place to minimize any potential harm of such things, in the rare circumstances
where they do occur. OK, so, moving on to a third example here. This is the Patriot missile system. So, this missile system was
originally designed by the US Army to shoot down airplanes
in the Gulf War of 1991. The Army put the Patriot
missile system to work, defending against Scud missiles
launched at Israel and Saudi Arabia. At the end of the Gulf War,
the Army claimed that the Patriot missile defense
system had been 95% accurate, or effective at destroying
incoming Scud missiles. But later analyses showed that
perhaps as little as 9% of the Scuds were actually destroyed
by the Patriot missiles. So, in retrospect, as it turns out, many Scuds simply fell apart as
they approach their targets. The destruction had
nothing at all to do with the Patriot missiles launched at them. One of the most notable failures
of this Patriot missile system occurred the night of
February 25, 1991, when a Scud missile
fired from Iraq hit a US Army barracks killing 28 soldiers. The Patriot missile battery,
defending the area never even fired at the incoming Scud. A report traced a failure
of the Patriot system to a surprisingly trivial software error. The Patriot system failed
to track and intercept the incoming Scud due to
a truncation error involving a loss of precision in converting integers to a floating-point number representation. So, to elaborate on that,
what went wrong, a bit more. The Patriot missile battery
did detect the incoming Scud missile as it first
came over the horizon, you can refer to this graphic as well. But in order to prevent the system
from responding to false alarms, the computer had been programmed
to check multiple times in the course of its
trajectory for the missile, it would do this by predicting
the flight path of the incoming missile directing the radar to focus on
that area where it predicted to be, and scanning a segment of that area
called a range gate for the target. In this particular case,
the program scan the wrong range gate and thus failed
to detect the missile. So why was the wrong range
gate scanned by the program? That's the question. The prediction of where
the Scud will appear, that will next appear is a function
of the Scuds velocity, of course, determined by its change in
position with respect to time, but time is updated in
the Patriots internal system clock in 100-millisecond intervals. Velocity on the other hand was represented as a 24-bit floating-point variable, and time as a 24-bit integer. But both must be represented as
a 24-bit floating-point number in order to predict where
the Scud will next appear. So, the conversion from
integer time, the real-time, resulted in loss of
precision that increases as the internal clock time increases. The error introduced by
the conversion results in and there in the range gate computation
proportional to the targets velocity, and the length of time that
the system was running. So the longer the system ran, the more
those truncation errors added up, leading to disaster. So originally, the Patriot
missile system was designed to operate a few hours at
a time, but the particular system
in question had been operating continuously for over
100 hours. And the accumulation of
errors led to a difference, rather significant difference
between the actual time and the computer time of about half
a second, or a third of a second. But missiles travel at very high speeds of course so that the third of a second or half of a second error led to a tracking error of about half a mile actually. And this was enough of an error
to prevent the missile battery from detecting the Scud
in the range gate area. OK, so example four, concerns
the Ariane 5 which was a Satellite Launch Vehicle designed
by a French space agency. During its maiden flight in 1996
about 40 seconds after takeoff, a software error caused
the active and backup computers to shut down resulting
the total loss of altitude control. The vehicle then self-destructed. While no one was injured thankfully, the uninsured rocket carried satellites
worth $500 million, making it the costliest error in
dollar terms in history at that time. The software error that ultimately led to the crash was traced to a piece of code that converts a 64-bit floating-point value into a 16-bit signed integer. The input value that was to be converted ended up exceeding the range of what could be represented as
a 16-bit signed integer, leading to overflow error. Moreover, there was no explicit Exception Handler to catch the OverflowException. So the uncaught exception
crashed the entire software and the onboard computers. Arguably, this unhandled
OverflowException was the main reason for the disaster. Now as a turned up, the particular
piece of code that was problematic, had been part of the 10-year-old software that was used for the Ariane 4, an earlier version of this craft. Furthermore, the code
that might have caught and handled the conversion errors had been actually disabled on
the Ariane 4 since for that system, performance constraints made
such overflow errors irrelevant. Yet as it turned out,
those same performance constraints did not apply to the Ariane 5 because the velocity that was reachable by the Ariane 5 was much greater. It was too high specifically
to be represented as a 16-bit integer, yet Exception Handling
had been suppressed. So the Adder language which was used for Ariane software generates an exception. If a floating-point number is too
large to be converted to an integer, but the programmers of the Ariane 5, had decided that the situation
would never happen, and following basically, the way
the Ariane 4 version was designed, and thus they didn't provide
an Exception Handler. The original programmer of
the subprogram for converting a floating-point number to
assign 16-bit number likely realized that the value of
the floating-point number to be converted must lie
within a restricted range. But such restrictions on input values, you could think of as preconditions for subprograms were
neither systematically derived nor well documented. A decision was made by the
Ariane 5 team to not provide an OverflowException Handler because the processor
was already heavily loaded. So, the code was designed such that
in the event of any exception, the failure should lead to
the main processor to be shut down, and to switch to a backup. Since there was no
Exception Handler in the code, when the overflow happened, the main software component
failed and the system attempted to revert to the backup system. However, that backup system,
which was based on the Ariane 4 was identical in hardware
and software to the active one. And so it could not be activated because it failed for the exact same reason. Now finally, an irony that
was that the overflow conversion error that caused the issue occurred in a routine that had been simply reused from the Ariane 4 vehicle, but was not even an appropriate
computation to require for the Ariane 5. Moreover, as the computation
that failed was not supposed to be required
for the Ariane 5, there was no associated
requirements and no tests were made of that portion of the software, and the main code component in question had been validated for the Ariane 4. So no further testing with hardware
or software or test simulations of real data from the actual Ariane 5
trajectory were ever performed. OK, so what are some lessons here that
we can draw from these last few examples? So the first concerns were built off of the Patriot missile example in particular. So we can say apparently
small errors can accumulate and have non small consequences. So one deliberate and that's
something we should draw from that. And so we should take seriously
the treatment of types, errors and final computations
that can occur by, for instance, treating a floating point
value like an integer and so on. And as you see in these examples, the consequences are not just
annoying to programmers, but can be really devastating. So the second lesson
concerning the Ariane 5 is that it can be dangerous to reuse code, especially without a precise
specification mechanism. So any software element with
a fundamental constraint should state this explicitly
and provide thorough documentation. Without that, it's safer
to redo rather than reuse. So this Ariane 5 example
demonstrates, or as it demonstrates, assumptions that were valid
when the code was originally written may no longer be true
when the code is reused, since some of these assumptions
or constraints may not be stated explicitly
or well documented. A new team taking on
or reusing elements of that code might not have the opportunity or inclination to check
if those assumptions still hold true in the new system. So in programming courses, one
often learns to reuse code, but the Ariane 5 incident
provides a cautionary tale for what can go wrong if we aggressively
reuse code in a thoughtless manner or do not provide
proper documentation. Note that reusing code does not always
increase the quality of the final product and can in fact lead to
disaster in such cases like this. So sometimes we assume
that by reusing code, things will be more reliable right? After all, we think the code
had been part of systems that were used for years
with no problems occurring. But that assumption can
turn out to be the wrong one to make and have
disastrous consequences, for errors might remain undetected
or not present problems in earlier iterations, yet such code features may introduce
grave errors in the presence of new updates to other system components or conditions or under other relevant assumptions. OK, for the fifth example here, this concerns NASA's Mars Climate
Orbiter, which was built by NASA to
facilitate communications between Earth and automated probes on the surface of Mars,
including the Mars Polar Lander. In 1999, the spacecraft was lost
because of a miscommunication, ironically enough, between
two support teams on Earth. The issue could ultimately be
traced back to the fact that the flight operations team
based in Colorado designed its software to use English
units so that its program output thrust in terms
of foot pound units. But the navigation team, which
they were working with at the Jet Propulsion Lab in
California, on the other hand, designed its software to use metric units, so its program expected thrust
to be input in terms of Newtons. So one foot pound equals 4.45
Newtons and the incident in question here happened
on September 23rd 1999, when the climate orbiter was
nearing Mars and when it was time for the spacecraft to fire
its engines to enter orbit. The Colorado team supplied a thrust
information to the California team, which then related to the spacecraft. But there was, of course, a unit mismatch, so the navigation team specified 4.45 times too much thrust, and the orbiter flew too
close to the surface of Mars and burned up in its atmosphere. So a specific lesson here
is that systems can fail on account of miscommunication
among people, and that includes also
miscommunication between, by let's say, poor documentation
by earlier programmers of earlier versions of the code. In this particular case, the output
of one program was incompatible with the input to the other program
and a poorly specified interface, together with miscommunication
between the relevant teams, allowed this error to
remain undetected until after the spacecraft was destroyed. LECTURER: Alright. So for the sixth and final example
in this section and in this module, we're gonna look at flash
crashes in financial markets. So a flash crash is basically
when there is a sudden and extreme plunge in prices of a stock, commodity bonds, currency
or some other security, something on the stock market. So and then followed by a quick recovery. So this graphic on the right
is of a particular stock, Accenture that experienced
one of these in 2010, and we'll talk about this particular
case in a couple of slides. So these are not generally
crashes that occur due to any perceived change in
the fundamental value of the stock. And there is indeed some debate about
what the ultimate cause a flash crash is. But this happened to be
semi-regular occurrences in financial markets to this day. So people are still trying to really get to the bottom of what the causes are. But it is evident that algorithmic trading and the heavy use of automated trading computer programs
and bots are one of the main causes. So as a particular instance of this, there was a famous or rather extreme flash crash in 2010, in May of 2010. And this led US stock indices,
including the Dow Jones, S&P 500 and the Nasdaq Composite Index, to really kind of jump off
a cliff and then partially rebound and all in less
than basically an hour. And the day was distinguished
by extremely high volatility, that means the price fluctuates
a lot and the market in general, the market indices managed to
partially rebound on the same day. But in the 15 minutes
that the entire crash, flash crash or debacle took to unfold, this flash crash erased almost
$1 trillion in market value. So after this first flash crash in 2010, there were congressional hearings
and other investigations. Since then, though, there
have been at least five other very notable flash crashes that have been affected or seen
or shown effects across major markets. But to this day, across all markets,
there are, by some estimates, at least 10 mini flash crashes per day. So this is still a pretty serious issue. OK, so just as a quick overview or higher, higher level overview, a bird's eye view, the market decline and market prices in the 2010 crash was triggered basically by a single selling order of a large
amount of particular S&P contracts, and this is what people largely
agree initiated things. But then there were subsequent
aggressive selling orders and automated strategies executed by record high
frequency trading algorithms. And we'll talk more
about this in a moment. Also, a small but not negligible delays suffered by the exchange computers and relaying accurate price data onto brokers and other trading platforms. And together with some complex
feedback loops involving trading bots and leading ultimately to
an accelerated downward price spiral. So let's break this down a bit more
though, that was pretty general. So breaking down the crash. First, one thing to understand
is automatic sell orders. So after the plunge in 2010,
several reports indicated that while the event may have
initially been triggered by an unusually large sell order
for particularly big stock that then kind of ramified
to the rest of the market, this incited massive algorithmic
trading automated orders to dump that stock via something
called a stop loss mechanism, which created a cascade of downward
and or additional sell pressure. So basically, a stop loss order is
an automatic or automated conditional trade order given to trigger a sale
of a particular stock let's say, when a certain price level
or threshold is reached to the downside, provided a sufficient volume is present. And this is typically used by
investors or traders to cut losses. So these orders have set the trigger once the price of a stock in
question falls below the specified stock
price threshold as over here and the graphic on the right. And these orders are
fundamentally designed to limit an investor's loss on a position. So the idea might be right,
if you bought something, let's say Apple stock at $100, you might say I'll let it
go up as much as it wants, and it can even go a little
bit below where I bought. But if it goes below $90, you know, at that point I'm not willing to hold on to it 'cause it might go way lower. So when it hits $90, I want to
get rid of it or sell it, right? So that's the idea here. But you wanna make sure that
there's sufficient volume, especially if you're
a big market participant. So you would need to check that
part of the condition as well. OK, but when a sell order for
a stop loss order is made, so that's to say, once the threshold is crossed, that particular stop loss
order threshold is crossed. You have to actually
place an order, right? And that order could get,
could execute either as what's called the market
order or a limit order. But typically, by default,
it's a more as a market order. A market order effectively
just execute immediately at whatever price the market
is trading at that moment, whereas limit orders is
a designated order that's put on the order books that gets filled only and further specified if that further specified limit price is reached. So the idea would be effectively
that if you had a limit order there, you would say OK, once the price
goes below my threshold of $90 , then provided it's still above, let's say, $89, you should sell at 89.50 or $90. And if it doesn't, if it moves too
quickly below that threshold, so it moves straight basically from
90 to 80 or something like that, then the order will not trigger at all, whereas the market order would just execute immediately or whatever price the market is trading at that moment. But the risk basically with the stop loss order executed as a market order, is that it triggers after a certain
threshold is reached and by the time the market order is
executed actually selling the stock, the price may have slipped or moved a great deal lower than that threshold, which would incur much bigger losses. So no matter how quickly
the price rebounds, once the stop loss is triggered, it is triggered and you would
sell at a loss provided it was executed in the market order. And this could be very extreme, especially if the price has moved
a lot from the trigger level. So just as a particular instance,
right of August 1, 2021 at 2:00pm., Let's say Apple stock is
trading for $200 per share. If you had this particular
stop loss order. Right? But let's say you placed
it at $200, right? But you have a market order, the market order does
not guarantee that your sell price or the buy price for that
matter, would be filled at $200. You might get your order filled at a price significantly lower than $200, depending on various factors
and at the time of fill. So in the case of
a highly volatile market, it's moving very quickly,
right or illiquid, meaning there's not enough
money on the market, actually, some price
can move very quickly. In those cases, a market order may
actually result by the time it's executed and a fill price that
differ significantly from $200. So we'll see why this matters
in a moment as we continue to unpack some of
the elements of this situation. OK, so another component here
is, high frequency traders, so high frequency traders, or HFT, using more sophisticated
algorithmic trading strategies and even hardware are another
factor in flash crashes. So HFT is making use of algorithms
to carry out large transactions, executed at very high speeds. They have, they also have
a number of sophisticated strategies or algorithms
to carry out market, what are now considered
market manipulation activities like something called spoofing, which is basically where
algorithms place fake but large sell orders on
the order books to intimidate or influence market
participants and then remove the order the moment it gets filled. So the purpose of spoofing can be
to create the illusion of volume or the illusion that the market will
move in a particular direction, artificially tricking market
participants into thinking that mass selling or buying is
happening when actually it's not. Since these orders are
not meant to be sold. And another purpose could be to
just kind of increase noise, confuse or outwit
or intimidate market competitors, clog exchanges and this kind of thing. There are further algorithmically
executed strategies, such as placing stub quotes
conditional on certain other factors, such as high volatility,
and that's what this image to the right is meant to illustrate. So a stub quote, also known
as a placeholder quote, is an order to buy or it's an automated
order to buy or sell its shares that's deliberately set far lower or higher than prevailing market price, and it's generally not
expected to execute. In extreme situations with extreme
volatility or extreme price swings, stub quotes may actually get executed, and this will exacerbate any
market volatility already present. So in the case of the let's say,
a particular stock that in 2010 was moving very extremely was
something called Accenture. In that case, market
participants attempted to drop out of the market
by posting stub quotes, including at ridiculous prices. So the stock had been trading
earlier for $40 dollars, say you know for a long
time or at $40 and 39, 41. But they placed stub
quotes prices of one cent, and many of those actually ended
up getting inadvertently filled. But the general idea here
with a stub quote is, if you look at this chart
here on the right, you know the yellow line might indicate, OK, that's a particular threshold. And the idea is if that threshold
is crossed, that goes below, the price goes below that
level and the volatility increases above a certain amount. So you could see it's moving quite quickly in a short amount of time down. And once those conditions are met, then an order should
be placed on the order books at an extremely low level, just in case it goes, that
becomes even more volatile. And this is one factor of
what happened in 2010, as more and more automated sell
orders went through the price, things became more and more volatile, and the stub quotes became
more and more ridiculous to the point that people were placing or bots are placing stub
quotes at prices for one cent and they actually were executing. OK. Further, there were some
important assumptions that were made by the bots, or you could say that we're kind of built in as conditions to some of the codes. So traditionally one would assume
that volume and that means the number of shares of a stock that changed
hands during a specified time period, one would assume that
volume is a good indicator or good measure of liquidity. Liquidity means of that kind
of actual market present, actual money present on the market.
Right? So one assumes basically
that one can conflate or equate volume and liquidity. So especially before algorithmic
trading entered the picture, this was an entirely sensible
assumption to make about the markets. If there is an increase in volume, it's because actual money has entered into the market and it's trading hands between actual people making an actual trade,
right? If there's little to no volume, it shows that kind of
liquidity has dried up. People are not interested
in trading that stock. But as algorithms and high frequency
traders become increasingly active in markets
throughout the early 2000s, computer driven trading
programs would pass stocks back and forth in a kind
of hot potato fashion, causing huge increases in trading volume. Without this often reflecting any actual increase in demand or any associated liquidity injections that would
normally come from this. So flash crashes like that of
2010 expose what you could call like the phantom liquidity
problem in a rather extreme way, meaning there's not really
actually liquidity there, or there's not an increase
in the amount of money that is being injected into that market. There's just the illusion of
that by increased volume. So in such cases of these crashes,
many of the algorithms themselves
continue to operate on the assumption that
volume was a reliable measure of market liquidity. But this assumption would
actually become invalid once enough parts had
permeated the markets. So another reasonable,
normally reasonable assumption made by the traders and their algorithms or the bots was that the quoted price of an asset so that the price basically that is being fed through some oracle to the bots or that the bot
is kind of checking is the price the quoted
price of this asset is equal to or reflects its actual price. So it's in other words, it's assumed that the price oracles feeded the algorithms. The price don't lie. But as we'll see,
this assumption also turned out to be mistaken in
the case of flash crashes. OK, first, let's make an observation. Let's consider the simplicity of each individual algorithm and assumption, I didn't write out what
the algorithms would look like, but they are really, truly quite simple. Each of the described
algorithms or training programs is remarkably simple on its own. Looking closely any one
of them individually, say the stop loss order mechanism
or the stop quote order. There may be no reason to suppose
that kind of global system market wide meltdown could arise from
any of these things, right? Moreover, the assumptions made and
certain of the conditionals that are kind of a part of or serve as
constraints or conditions in certain code components. These assumptions appear
entirely sensible and to any before kind of bots
permeated the market, they would have been
assumptions that people with domain specific
knowledge in this case, some knowledge of the markets
experience how markets work. They would have thought that they were entirely sensible assumptions to make. However, composed together, some of
these different algorithmic programs composed together were brought together
and under unexpected circumstances. When those the assumptions they
operated under became erroneous, extreme and unanticipated effects
emerged on a large scale. That's something a general
saying we want to observe in. OK. Terms of the particular assumptions. The problem was that
the assumption that trading volume is a good measure of liquidity. Money of market turned
out to be especially among those which had disastrous effects as the algorithms were composed
together and acted in concert. The increasingly aggressive selling
and buying of large volumes of securities stock by
the algorithmic trading bots resulted in an enormous price
volatility in high volume in this kind of just kept getting
aggravated more and more. So all of this volume was mistaken
because of the assumptions of these bots for
indicating high liquidity, meant which meant effectively to the bots, that they could execute
market orders because they were under the impression effectively that there was enough liquidity
or demand or money to fill their orders. So they thought I can exit
because there's a lot of volume. That means is a lot of
money in the market. So I can execute a market order
and there'll be enough money there, kind of to fill my order at
the price that I'm kind of asking for. But there was not actually
that liquidity or demand, that there was just the illusion
of that with the high volume. So the orders would actually fill
at prices that deviated from their stop loss thresholds by
a lot or their expected price. And because of the additional
presence of these stock quotes and the additional factors of spoofing
and a number of other factors. These the field prices would often differ by ridiculous amounts of leading the general stocks to kind of fill prices that were really kind of ridiculous. So, you know, stocks trading at
forty dollars, for instance, like Accenture trading for
a moment at one more cent. Right? Furthermore, in terms of
the second assumption, covered an analysis of trading on
the exchanges during the moments immediately prior to the flash
crash revealed technical glitches in the reporting of prices
on the stock exchange. And this further contributed
to the drying up of liquidity. So according to this analysis,
technical problems with the New York Stock Exchange led to
delays as long as five minutes in the quotes being reported on
the system that would report the current quoted prices
to, let's say, traders. At the same time, there
were also errors and some of the prices of some
stocks uncertain about the prices on many market
participants attempted to drop out of the market
by posting stock quotes. Many high frequency trading
algorithms attempted to exit the market with their
fast market orders, and they felt they could
do so safely with under the assumption that there
was enough liquidity. And this kind of began
or compounded to create an arms race to the bottom to
the point that in a flash, many orders got executed
at subsequent levels, leading to ridiculous low
prices in many stocks. OK, so wrapping things up,
the ultimate cause of the 2010 crash, we can talk about it as being a particular combination of the algorithms
compounded. So it started kind of with
an initial automated order, a large sell order and then many stock thresholds that loss
thresholds on these automated stop loss sell orders would get triggered. But there was also increased trading
volume going on and the automated trading programs operated under
the assumption that trading volume is a good measure of market
liquidity and liquidity generally means that one can exit
safely with a market order. And this led to increased sell pressure, often with market orders
coupled with scarce liquidity. This actually led to increased volatility, and the order is actually
being felt at levels that deviated greatly from
the stop loss threshold trigger an extreme price reduction. Altogether, these factors led
lead to trades being executed, absurdly low prices
and many stocks and prices wildly different from the quoted prices. There were some further exacerbating
factors that were mentioned. So the algorithmic trading bouts
since they were often sorry, also spoofing the order
books and there were technical glitches and price oracles. And since the market
was actually illiquid, meaning there wasn't really
much money or demand there. Contrary to what a volume
indicated and as many high frequency trading algorithms
attempted to exit the market with market
orders as fast as possible, which were then executed
with stock prices. All of this had kind of
a compounding domino effect, leading prices to kind of
cascade down extremely quickly. OK, so stepping back now
and looking at some lessons that we can draw from this example
of the flash crashes, so again, as I pointed
out a couple slides ago, it's important to realize that
individually the programs that contributed to the flash
crash were not particularly intelligent or sophisticated
or complicated or indicative that there would be much
of a problem, right? So, for instance,
you know, so if a certain price threshold is reached and liquidity, so the volume is above some level. It's quite simple the right. However, here's
the lesson we could call this the lesson of emergent
failure interactions between individually simple code
components or programs can produce unexpected
effects when composed, especially under the presence
of kind of violation of otherwise sensible assumptions. So systemic risks can build up a new
simple elements are introduced to a system once a certain threshold of,
let's say, composability is met. So you have enough code components
or different algorithms that are being combined
or perhaps once extreme conditions edge cases arise
or under the presence of certain assumptions
that become invalidated. In such cases, the risks
may not even be obvious until after something goes wrong. In practice, such failures often
pair with cascade effects multiple failures that
an isolation may have been minor, easily contained, but in
concert produce aggregate disaster or consequences
of great magnitude. So the kind of lesson here is
don't underestimate the power of composability and how
many different protocols, code, components and systems
can interface or interact. And their vulnerabilities compound
to create emergent failures that as failures do not appear at
the level of any single one of them, but that when in combination
or that can arise in combination of those
different components. So a second lesson we could
call the perils of consistency. So smart professionals
or people with domain specific knowledge like in this case, the people with experience
and how markets work, they might give instructions to
a program based on or to programmers based on an ordinarily or previously
sensible and sound assumption. So, for instance,
the assumption that trading volume is a reliable indicator
of market liquidity, but this can produce catastrophic results when the program continues to act on that instruction
with a kind of ironclad or strict logical consistency, even in unexpected situations where
the assumption becomes invalidated. So remember, an algorithm
just does what it does, it doesn't care that we didn't want
some unanticipated inappropriate action or that we didn't
anticipate new conditions or edge cases that would
invalidate the assumption. So we need to. The lesson here is we need to
carefully scrutinize assumptions and even consider those unlikely
conditions or consider cases, however unlikely they might seem, that would invalidate seemingly
sensible assumptions. So especially useful here. Generally speaking, our red
teams and other groups of fresh eyes who would look for exploitable
aspects of the system. A third lesson is that we
should automate safety. The need for pre-installed
and automatically executing safety functionality that is as opposed to reliance on runtime, human supervision can be really crucial. So some have put forth
the theory that the high frequency traders in the case of
the flash crash and automated mechanisms were actually
a major factor in minimizing and reversing in a flash crash in here. So actually, all of this, even though wiped off a $1
trillion off the market. If you look at many of
the charts for that day, they kind of rebounded
right back to the previous levels they were at within
a couple of minutes. And this was actually because a lot of kind of safety automated mechanisms were kind of triggered to shut down market trading and to reverse things. So in other words, even
while automation or certain algorithms contributed to the incident, it also contributed to
its swift resolution. And many people who did an analysis of this agreed that no human would have been able to kind of step in and stop
things or fix things as quickly. So the pre-programmed
logic which ultimately suspended trading when
prices moved too far, was set to execute
automatically because it incorrectly anticipated
that the triggering events could happen on a time scale,
too swift for humans to respond. OK, so a fourth risk here is
that you should spread out risk, right, so if you're going to use, for instance, Oracle's feeding data about, let's say, price from one source, assume that if an agent can
manipulate that data at the source or if something can go wrong
with the data at that source, there can be inaccuracies assume that that will happen and actually perform the calculations to figure out what will happen when that does take place,
right? Then, do what you can to spread out
risk by incorporating data feeds, let's say, from multiple sources. So in general, also anticipate
and minimize damage if you cannot guarantee the elimination of
certain risks or vulnerabilities, at least ensure that
the total amount lost or damage done to users or people
affected by your code is on a smaller scale
or is contained so dangerous cannot be avoided and put caps on them. A fifth lesson is don't
cut corners, right? So people often are most concerned
and in a lot of industries, and you will certainly
experience this if you have not already with prioritizing
shipping as fast as possible or getting things back up
and running after your problem. But rushing these things can, in many
cases, have very bad consequences, so always prioritize
safety over speed, right? So these days, there's a lot
of pressure to ship quickly, even if this means making
sacrifices to quality or integrity or any
number of other things. But remember, you know,
the mantra break things first, ask questions later. While it might sound fun is very
questionable advice ethically speaking, especially when a lot is at stake and especially when a lot of damage can be caused by any of the things that happen once when something is broken. OK, so finally, we're
almost wrapped up here, the maybe metal lessons we can
draw from all of these examples is that the goal is not
so much avoiding all problems. After all, if you knew about
them as problems to begin with, they would surely have been avoided,
as you know, in the first place. But rather a computerized
system should be designed in such a way that when problems do arise, that can be resolved and the system
can even be self-correcting. Moreover, as far as human
users and operators of the system are concerned, an important question to
always keep in mind is how do you write code
and align the incentives of the relevant users and programmers of such code or maintainers of such code? How do you write the code in such
a way that over the long term, whenever problems
or unintended results arise, the people involved have both
the incentives and the resources for repairing the system
and containing the damage. So is an important kind of
general question to are, let's say, a particular
lesson to keep in mind. SPEAKER 2: As we conclude, module one
here, some metal lessons learned from all of the examples and a final assignment. The goal is not so much
avoiding all problems. After all, if you knew about
them as problems to begin with, they would surely have been
avoided in the first place. Rather, computerized
system should be designed in such a way that when problems do arise, they can be resolved and
the systems can be self-correcting. Moreover, as far as human
users or operators of that system are concerned, an important question to always keep
in mind is how do you write code and in line the incentives of
the relevant users of such code? In a way that over the long term, whenever problems
or unintended results arise, the people involved have
both the incentives and the resources for
repairing the system. Now, for an assignment
reflecting on the Ariane five, we will see you in Module two.
