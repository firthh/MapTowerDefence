var fs = require('fs')
var mathExtention = require('./resources/js/mathExtention.js')

describe("A suite", function() {
  it("contains spec with an expectation", function() {
    expect(true).toBe(true);
  });
});

describe("distance", function() {
	it("should work from the origin", function() {
		expect(myCode.distance(0,0,1,2)).toEqual(3);
	});
});