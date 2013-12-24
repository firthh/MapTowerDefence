

describe("A suite", function() {
    it("contains spec with an expectation", function() {
        expect(true).toBe(true);
    });
});

describe("distance", function() {
    it("should work from the origin", function() {
	expect(distance(0,0,3,4)).toEqual(5);
    });
});
