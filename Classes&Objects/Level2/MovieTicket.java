class MovieTicket {
    String movieName;
    int seatNumber;
    double price;

    MovieTicket(String movieName, double price) {
        this.movieName = movieName;
        this.price = price;
    }

    void bookTicket(int seatNumber) {
        this.seatNumber = seatNumber;
        System.out.println("Ticket booked for seat: " + seatNumber);
    }

    void display() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Avengers", 350.0);
        ticket.bookTicket(42);
        ticket.display();
    }
}
