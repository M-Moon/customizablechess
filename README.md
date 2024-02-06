<h1 align="center">CustomizableChess</h1>

## Overview

This program is designed to play like any other chess program, running as a desktop
application on the JVM, but with a twist - you can add, remove, and customise pieces
as much as you want, including their movement, pictures, starting placement, and special
rules such as how [en passant](https://en.wikipedia.org/wiki/En_passant) is given for pawns.

## Goals

A smooth desktop experience where two players can play a customised version of chess
against each other, or (eventually) a basic AI opponent.

Original pieces can be modified, producing a new version but keeping the original in
the files, and customized pieces can again be modified, giving full freedom over
the chess board and its pieces

## Design

The important distinction is that the program will allow for a large number (infinite?) of
new or modified chess pieces whilst also maintaining access to all 6 original pieces, so that
a normal game can still always be loaded and played. This means the design will still be
in accordance with a normal chess program but with a few additions.

One notable addition will be creating a Modified-Customizable-FEN with its own rules.
This FEN will have all its normal rules but allow for new piece types to be added. One
way to do this is to make sure the FEN parser is quite general and extremely effective
at detecting individual tokens based on the current character it's parsing. Normal FEN
gives 1 character for each token, but to be able to introduce new pieces we will need
to have tokens of multiple characters so each new piece can be given a piece code that
has a defining first character. All of this is important so positions can be easily saved,
loaded, shared, etc.

On that note, we will need a way to export piece customization so it can be easily shared
or duplicated.

### Design Ethos

Importance will be placed on clean code and good design practices from the start to allow
this project to be worked on and extended over time. Good separation of concerns with decoupling
and following SOLID principles is essential, with classes such as 'Board' only storing and
handling the internal representation and changes to the board, not doing anything such as position
evaluating - this should be handled by a separate class that can have a Board object injected
into it.
