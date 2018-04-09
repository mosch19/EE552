class Vec3d {
    double x, y, z;

    Vec3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double dist(Vec3d b) {
        return 0.0;
    }

    public double distSq(Vec3d b) {
        return this.dist(b);
    }+
}
