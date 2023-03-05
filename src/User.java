public class User {
    int rank;
    int progress;

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void incProgress(int activity) {
        if (activity < -8 || activity == 0 || activity > 8) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }

        if(activity == rank) {
            progress += 3;
        }

        if(activity == rank - 1) {
            progress += 1;
        }

        int d = activity - rank;
        progress += 10 * d * d;

        if(rank < 8) {
            while (progress >= 100) {
                int updated = progress - 100;
                setProgress(updated);
                if(rank == -1) {
                    rank += 2;
                }
                else if(rank == 8) {
                    rank = 8;
                }
                else {
                    rank++;
                }
            }
        }
    }

    public User() {
        this.rank = -8;
        this.progress = 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "rank=" + rank +
                ", progress=" + progress +
                '}';
    }
}
