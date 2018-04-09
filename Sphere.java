class Sphere implements Shape3d {
    public double r;
    public Vec3d origin;

    Sphere(Vec3d origin, double r) {
        this.r = r;
        this.origin = origin;
    }
    // this calls the other constructor
    // have all constructors call the mega one with all the paramaters
    Sphere() {
        this(new Vec3d(0, 0, 0), 0);
    }

    @Override
    public boolean contains(Vec3d vector) {
        return origin.distSq(vector) < r*r;
    }

    // Should bounding sphere be its own object with special parameters?
    @Override
    public Sphere boundingSphere() {
        return this;
    }
}
