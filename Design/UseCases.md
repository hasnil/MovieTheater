# Use Cases and Scenarios

## View showtimes
This use case begins when user already selected a movie from the available movies list and selected ‘view showtimes’ function/button. At this point, system asks the user to select a movie theater where this movie is on show (option: select all theaters where this movie is showing). Afterwards, the system displays a list of available showtimes of this movie at the selected theater. If a showtime is selected by the user, then use case ‘View seats’, ‘Purchase tickets’ or ‘Reserve Seats’ become available.

## View seats
This use case begins when user already selected a showtime (from View showtimes case) for a selected movie/theater combination. At this point, system displays to user the graphical seat map of the theater, and showing also which seats are already sold and which ones are still available. If user clicks on an available seat from here, the seat will change the color as a visually indicate that seat is selected. From here, user can select another seat to change the selected seat or simply press cancel to annul seat selection. When a seat is selected, the use case ‘Purchase tickets’ or ‘Reserve Seats’ become available.

# Good-candidate Objects
User, movie, showtime, theater, seat, ticket, available

# Potential Operations
Select-seat
Cancel-seat-selection
Reserve-seat
Select-showtime-for-selected-theater
Display-showtime-in-selected-theater
Display-all-showtimes-in-all-theaters
Select-theater
